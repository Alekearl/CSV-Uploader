package com.http.program.uploadcsv.controller;

import com.http.program.uploadcsv.model.DataFile;
import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.model.dto.InformationFromCsv;
import com.http.program.uploadcsv.service.InformationService;
import com.http.program.uploadcsv.service.mapper.InformationCsvMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/uploads")
public class UploadController {
    private final InformationService informationService;
    private final InformationCsvMapper informationCsvMapper;

    @Autowired
    public UploadController(InformationService informationService,
                            InformationCsvMapper informationCsvMapper) {
        this.informationService = informationService;
        this.informationCsvMapper = informationCsvMapper;
    }

    @PostMapping("/upload/csv-file")
    public void uploadCsvFile(@RequestParam("file") MultipartFile file) {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<DataFile> csvToBean = new CsvToBeanBuilder<DataFile>(reader)
                    .withType(DataFile.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<DataFile> parse = csvToBean.parse();
            for (DataFile dataFile : parse) {
                InformationFromCsv informationFromCsv = new InformationFromCsv();
                informationFromCsv.setEmployee(dataFile.getEmployee());
                informationFromCsv.setDepartment(dataFile.getDepartment());
                informationFromCsv.setSalary(dataFile.getSalary());
                Information information = informationCsvMapper.fromCsvToDb(informationFromCsv);
                informationService.save(information);
            }
        } catch (Exception e) {
            throw new RuntimeException("Please select a CSV file to upload.", e);
        }
    }
}
