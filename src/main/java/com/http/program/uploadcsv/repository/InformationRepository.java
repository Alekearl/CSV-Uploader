package com.http.program.uploadcsv.repository;

import com.http.program.uploadcsv.model.Information;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InformationRepository extends JpaRepository<Information, Long> {
    @Query("FROM Information i WHERE i.department = :department ORDER BY i.salary DESC")
    List<Information> getAllEmployeeWithHighestSalaryInDepartment(String department);

    @Query("FROM Information i WHERE i.employee <> '' AND i.employee IS NOT NULL ORDER By i.department, i.salary DESC")
    List<Information> findAllByDepartmentAndEmployeeContainsOrderBySalaryDesc();
}
