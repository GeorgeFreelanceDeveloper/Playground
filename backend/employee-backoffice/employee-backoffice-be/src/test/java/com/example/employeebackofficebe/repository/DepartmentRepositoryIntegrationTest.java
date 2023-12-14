package com.example.employeebackofficebe.repository;
import com.example.employeebackofficebe.model.db.DepartmentEntity;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class DepartmentRepositoryIntegrationTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testLoadDepartment() {
        String departmentNo = "d009";

        Optional<DepartmentEntity> departmentDbWrapper = departmentRepository.findById(departmentNo);

        assertFalse(departmentDbWrapper.isEmpty());

        DepartmentEntity departmentEntity = departmentDbWrapper.get();
        assertEquals(departmentNo, departmentEntity.getDeptNo());
        assertEquals("Customer Service", departmentEntity.getDeptName());
        }

    @Test
    public void testFindAllDepartments() {
        List<DepartmentEntity> departments = departmentRepository.findAll();
        assertTrue(departments.size() > 8);
    }
}
