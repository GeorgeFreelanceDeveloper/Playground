package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.TitleEntity;
import com.example.employeebackofficebe.model.db.key.TitleKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<TitleEntity, TitleKey> {

    List<TitleEntity> findByEmpNo(Integer empNo);
}
