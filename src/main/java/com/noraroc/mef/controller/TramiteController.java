package com.noraroc.mef.controller;

import com.noraroc.mef.dao.TramiteRepository;
import com.noraroc.mef.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TramiteController {

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/form")
    public String formularioTramite(Model model) {
        model.addAttribute("tramite", new Tramite());
        return "formulario";
    }

    @PostMapping("/form")
    public String submitTramite(@ModelAttribute Tramite tramite) {
        tramiteRepository.save(tramite);
        return "success";
    }

    @PostMapping("/import")
    public String importCsvFile(@RequestParam("file") MultipartFile file) {
        // TODO

//        // validate file
//        if (file.isEmpty()) {
//            return "Please select a CSV file to import.";
//        }
//
//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
//             CSVParser csvParser = new CSVParser(fileReader,
//                     CSVFormat.DEFAULT.withFirstRecordAsHeader()
//                             .withIgnoreHeaderCase()
//                             .withTrim());) {
//
//            List<Tramite> tramiteList = new ArrayList<Tramite>();
//
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//            for (CSVRecord csvRecord : csvRecords) {
//                Tramite entity = new Tramite(
//                        null,
//                        csvRecord.get("codigo"),
//                        csvRecord.get("nombre"),
//                        csvRecord.get("comprobante"),
//                        csvRecord.get("resumen"),
//                        Double.parseDouble(csvRecord.get("monto")),
//                        LocalDate.parse(csvRecord.get("fecha_conclusion")),
//                        csvRecord.get("vinculo")
//                );
//
//                tramiteList.add(entity);
//            }
//
//            // save entities in the database
////            myEntityRepository.saveAll(entities);
//
//            return "Successfully imported!";
//        } catch (IOException e) {
//            return "error";
////            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
//        }
        return "error";
    }
}
