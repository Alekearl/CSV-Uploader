package com.http.program.uploadcsv.service;

import com.http.program.uploadcsv.model.Information;
import java.util.List;

public interface InformationService {
    List<Information> getAllEmployees();

    List<Information> getAllWithHighestDepartmentSalary(String department);

    List<Information> getAllDepartmentsContainEmployeeSortedBySalaryDesc();
}
