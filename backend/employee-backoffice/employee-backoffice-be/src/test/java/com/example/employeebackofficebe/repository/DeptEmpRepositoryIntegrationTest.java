package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.DeptEmpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DeptEmpRepositoryIntegrationTest {

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    @Test
    void testFindByDepartmentNo() {
        List<DeptEmpEntity> deptEmployees = deptEmpRepository.findByDeptNo("d001");
        Set<Integer> actualEmployeesIds = deptEmployees.stream().map(de -> de.getDeptEmployee().getEmpNo()).collect(Collectors.toSet());

        assertTrue(deptEmployees.size() == 20211);
        assertTrue(actualEmployeesIds.containsAll(Set.of(458759, 65536, 229378)));
    }

    @Test
    void testFindByEmpNo() {
        List<DeptEmpEntity> deptEmpEntities = deptEmpRepository.findByEmpNo(110039);
        Set<String> actualDepartmentIds = deptEmpEntities.stream().map(dm -> dm.getDepartment().getDeptNo()).collect(Collectors.toSet());
        Set<String> expectedDepartmentIds = Set.of("d001");

        assertTrue(deptEmpEntities.size()==1);
        assertEquals(expectedDepartmentIds, actualDepartmentIds);
    }
}
