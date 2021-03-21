package com.http.program.uploadcsv.model;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Column;
import lombok.Data;

@Data
public class DataFile {
    @CsvBindByName
    @Column(name = "Employee")
    private String employee;
    @CsvBindByName
    @Column(name = "Department")
    private String department;
    @CsvBindByName
    @Column(name = "Salary")
    private Double salary;
}
