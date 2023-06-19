package com.noraroc.mef.controller;

import com.noraroc.mef.model.entity.Tramite;
import com.noraroc.mef.model.service.TramiteService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public String submitTramite(@ModelAttribute Tramite tramite) {
        Tramite newTramite = tramiteService.save(tramite);
        return "success";
    }

    @PostMapping("/import")
    public String importCsvFile(@RequestParam("file") MultipartFile file) {

        // validate file
        if (file.isEmpty()) {
            return "error";
        }

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader()
                             .withIgnoreHeaderCase()
                             .withTrim());) {

            List<Tramite> tramiteList = new ArrayList<Tramite>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag("es"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

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

                    tramiteList.add(entity);
                } catch (NumberFormatException e) {
                    // Log the error and continue with the next row
                    System.err.println("Invalid number format in row " + csvRecord.getRecordNumber() + ": " + e.getMessage());
                } catch (DateTimeParseException e) {
                    // Log the error and continue with the next row
                    System.err.println("Invalid date format in row " + csvRecord.getRecordNumber() + ": " + e.getMessage());
                } catch (ParseException e) {
                    System.err.println("Invalid date format in row " + csvRecord.getRecordNumber() + ": " + e.getMessage());
                }
            }

            // save entities in the database
            tramiteService.saveAll(tramiteList);

            return "success";
        } catch (IOException e) {
            return "error";
        }
    }
}
