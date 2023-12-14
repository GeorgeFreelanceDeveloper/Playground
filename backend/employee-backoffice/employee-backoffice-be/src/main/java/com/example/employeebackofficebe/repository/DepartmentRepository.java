package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String> {
}
