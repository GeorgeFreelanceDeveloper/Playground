package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.SalaryEntity;
import com.example.employeebackofficebe.model.db.key.SalaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryEntity, SalaryKey> {
    List<SalaryEntity> findByEmpNo(Integer empNo);
}
