package com.http.program.uploadcsv.service.mapper;

import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.model.dto.InformationFromCsv;
import org.springframework.stereotype.Component;

@Component
public class InformationCsvMapper {
    public Information fromCsvToDb(InformationFromCsv informationFromCsv) {
        Information information = new Information();
        information.setEmployee(informationFromCsv.getEmployee());
        information.setDepartment(informationFromCsv.getDepartment());
        information.setSalary(informationFromCsv.getSalary());
        return information;
    }
}
