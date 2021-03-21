package com.http.program.uploadcsv.repository;

import com.http.program.uploadcsv.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
