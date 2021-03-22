package com.http.program.uploadcsv.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class DataFile {
    @CsvBindByPosition(position = 0)
    private String employee;
    @CsvBindByPosition(position = 1)
    private String department;
    @CsvBindByPosition(position = 2)
    private Double salary;
}
