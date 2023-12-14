package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.EmployeeEntity;
import com.example.employeebackofficebe.model.db.enums.GenderDb;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployeeRepositoryIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testLoadEmployee() {
        final Optional<EmployeeEntity> employeeWrapper = employeeRepository.findById(10001);

        assertTrue(employeeWrapper.isPresent());

        final EmployeeEntity employee = employeeWrapper.get();
        assertEquals(LocalDate.of(1953, 9, 2), employee.getBirthDate());
        assertEquals("Georgi", employee.getFirstName());
        assertEquals("Facello", employee.getLastName());
        assertEquals(GenderDb.M, employee.getGender());
        assertEquals(LocalDate.of(1986, 6, 26), employee.getHireDate());
        assertEquals(17, employee.getSalaries().size());
        assertEquals(1, employee.getTitles().size());
    }

    @Test
    public void testFindAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        assertTrue(employees.size() > 100);
    }

    @Test
    public void testCreateEmployee() {
        EmployeeEntity employee = new EmployeeEntity(
                LocalDate.of(1990, 1, 1),
                "Jan",
                "Novak",
                GenderDb.M,
                LocalDate.of(2000, 1, 1)
        );
        employeeRepository.save(employee);
    }

}