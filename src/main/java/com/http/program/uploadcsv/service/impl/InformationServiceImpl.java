package com.http.program.uploadcsv.service.impl;

import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.repository.InformationRepository;
import com.http.program.uploadcsv.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {
    private final InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public void save(Information information) {
        informationRepository.save(information);
    }
}
