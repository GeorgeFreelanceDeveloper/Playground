package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
