package com.http.program.uploadcsv.controller;

import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.service.InformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class InformationController {
    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/all/employee")
    public List<Information> getAllEmployee() {
        return informationService.getAllEmployees();
    }

    @GetMapping("/all-departments/highest-salary")
    public List<Information> getHighestSalaryInDepartments() {
        return informationService.getAllWithHighestDepartmentSalary();
    }
}
