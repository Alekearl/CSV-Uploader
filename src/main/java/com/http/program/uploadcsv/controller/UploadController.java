package com.http.program.uploadcsv.controller;

import com.http.program.uploadcsv.model.DataFile;
import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.model.dto.InformationFromCsv;
import com.http.program.uploadcsv.reader.ReaderCsv;
import com.http.program.uploadcsv.service.UploadService;
import com.http.program.uploadcsv.service.mapper.InformationCsvMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/uploads")
public class UploadController {
    private final UploadService uploadService;
    private final InformationCsvMapper informationCsvMapper;
    private final ReaderCsv readerCsv;

    @Autowired
    public UploadController(UploadService uploadService,
                            InformationCsvMapper informationCsvMapper,
                            ReaderCsv readerCsv) {
        this.uploadService = uploadService;
        this.informationCsvMapper = informationCsvMapper;
        this.readerCsv = readerCsv;
    }

    @PostMapping("/upload/csv-file")
    public ResponseEntity<List<DataFile>> uploadFile(@RequestParam("data") MultipartFile file) {
        List<DataFile> dataFiles = readerCsv.fileReader(file);
        for (DataFile dataFile : dataFiles) {
            InformationFromCsv informationFromCsv = new InformationFromCsv();
            informationFromCsv.setEmployee(dataFile.getEmployee());
            informationFromCsv.setDepartment(dataFile.getDepartment());
            informationFromCsv.setSalary(dataFile.getSalary());
            Information information = informationCsvMapper.fromCsvToDb(informationFromCsv);
            uploadService.save(information);
        }
        return new ResponseEntity<>(dataFiles, HttpStatus.OK);
    }
}
