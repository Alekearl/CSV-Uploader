package com.http.program.uploadcsv.service.impl;

import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.repository.InformationRepository;
import com.http.program.uploadcsv.service.InformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {
    private final InformationRepository repository;

    @Autowired
    public InformationServiceImpl(InformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Information> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public List<Information> getAllWithHighestDepartmentSalary() {
        return repository.getAllEmployeeWithHighestSalaryInDepartment();
    }
}
