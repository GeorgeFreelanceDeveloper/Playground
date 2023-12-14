package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.DeptManagerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DeptManagerRepositoryIntegrationTest {

    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Test
    void testFindByDepartmentNo() {
        List<DeptManagerEntity> deptManagers = deptManagerRepository.findByDeptNo("d001");
        Set<Integer> actualManagerIds = deptManagers.stream().map(dm -> dm.getManager().getEmpNo()).collect(Collectors.toSet());
        Set<Integer> expectedManagerIds = Set.of(110022, 110039);

        assertTrue(deptManagers.size() == 2);
        assertEquals(expectedManagerIds, actualManagerIds);
    }

    @Test
    void testFindByEmpNo() {
        List<DeptManagerEntity> deptManagers = deptManagerRepository.findByEmpNo(110039);
        Set<String> actualDepartmentIds = deptManagers.stream().map(dm -> dm.getDepartment().getDeptNo()).collect(Collectors.toSet());
        Set<String> expectedDepartmentIds = Set.of("d001");

        assertTrue(deptManagers.size()==1);
        assertEquals(expectedDepartmentIds, actualDepartmentIds);
    }
}