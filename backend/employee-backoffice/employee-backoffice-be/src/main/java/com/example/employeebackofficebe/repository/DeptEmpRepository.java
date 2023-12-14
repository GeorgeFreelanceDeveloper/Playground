package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.DeptEmpEntity;
import com.example.employeebackofficebe.model.db.key.DeptEmpKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptEmpRepository extends JpaRepository<DeptEmpEntity, DeptEmpKey> {

    List<DeptEmpEntity> findByDeptNo(String deptNo);
    List<DeptEmpEntity> findByEmpNo(Integer empNo);
}
