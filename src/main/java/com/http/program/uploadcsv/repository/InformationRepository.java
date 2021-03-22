package com.http.program.uploadcsv.repository;

import com.http.program.uploadcsv.model.Information;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InformationRepository extends JpaRepository<Information, Long> {
    @Query("FROM Information i GROUP BY i.department ORDER BY MAX(i.salary)")
    List<Information> getAllEmployeeWithHighestSalaryInDepartment();
}
