package com.http.program.uploadcsv.service.impl;

import com.http.program.uploadcsv.model.Information;
import com.http.program.uploadcsv.repository.InformationRepository;
import com.http.program.uploadcsv.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    private final InformationRepository informationRepository;

    @Autowired
    public UploadServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public void save(Information information) {
        informationRepository.save(information);
    }
}
