package com.noraroc.mef.controller;

import com.noraroc.mef.model.entity.Tramite;
import com.noraroc.mef.model.service.TramiteService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Controller
@RequestMapping("/tramite")
public class TramiteController {

    @Autowired
    private TramiteService tramiteService;

    @GetMapping("/form")
    public String formularioTramite(Model model) {
        model.addAttribute("tramite", new Tramite());
        return "formulario";
    }

    @PostMapping("/form")
    public String submitTramite(@ModelAttribute @Valid Tramite tramite, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formulario";
        }

        Tramite newTramite = tramiteService.save(tramite);
        model.addAttribute("new", newTramite);
        return "success";
    }


    @PostMapping("/import")
    public String importCsvFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            return "error";
        }

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader()
                             .withIgnoreHeaderCase()
                             .withTrim());) {

//            List<CSVRecord> recordsFallidos= new ArrayList<>();
            Map<CSVRecord, String> recordsFallidos = new HashMap<>();
            List<Tramite> tramiteList = new ArrayList<Tramite>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag("es"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            for (CSVRecord csvRecord : csvRecords) {
                try {
                    Tramite entity = new Tramite(
                            csvRecord.get("codigo"),
                            csvRecord.get("nombre"),
                            csvRecord.get("numeroComprobante"),
                            csvRecord.get("resumen"),
                            format.parse(csvRecord.get("monto")).doubleValue(),
                            LocalDate.parse(csvRecord.get("fechaConclusion"), formatter),
                            csvRecord.get("vinculoDocumentoDigital")
                    );

                    // valida la entidad
                    Set<ConstraintViolation<Tramite>> violations = validator.validate(entity);
                    if (violations.isEmpty()) {
                        tramiteList.add(entity);
                    } else {
                        // recorre las violaciones de las restricciones y añade los mensajes de error a recordsFallidos
                        for (ConstraintViolation<Tramite> violation : violations) {
                            recordsFallidos.put(csvRecord, violation.getMessage());
                        }
                    }
                } catch (NumberFormatException e) {
                    recordsFallidos.put(csvRecord, "Error de formato de numero.");
                } catch (DateTimeParseException e) {
                    recordsFallidos.put(csvRecord, "No se pudo converir la fecha.");
                } catch (ParseException e) {
                    recordsFallidos.put(csvRecord, "Error al convertir un valor.");
                } catch (ConstraintViolationException e) {
                    recordsFallidos.put(csvRecord, e.getMessage());
                }
            }

            // save entities in the database
            model.addAttribute("errores", recordsFallidos);
            tramiteService.saveAll(tramiteList);

            return "success_upload";
        } catch (IOException e) {
            return "error";
        }
    }
}
