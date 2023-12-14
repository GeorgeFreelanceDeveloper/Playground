package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.DeptManagerEntity;
import com.example.employeebackofficebe.model.db.key.DeptManagerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptManagerRepository extends JpaRepository<DeptManagerEntity, DeptManagerKey> {

    List<DeptManagerEntity> findByDeptNo(String deptNo);

    List<DeptManagerEntity> findByEmpNo(Integer empNo);

}
