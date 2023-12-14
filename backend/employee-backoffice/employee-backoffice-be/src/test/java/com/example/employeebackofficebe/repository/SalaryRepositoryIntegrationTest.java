package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.SalaryEntity;
import com.example.employeebackofficebe.model.db.key.SalaryKey;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class SalaryRepositoryIntegrationTest {

    @Autowired
    private SalaryRepository salaryRepository;

    @Test
    public void testLoadSalary() {
        Integer empNo = 10001;
        LocalDate fromDate = LocalDate.of(1986, 6, 26);
        LocalDate toDate = LocalDate.of(1987, 6, 26);

        Optional<SalaryEntity> salaryDbWrapper = salaryRepository.findById(new SalaryKey(empNo, fromDate));
        assertTrue(salaryDbWrapper.isPresent());

        SalaryEntity salaryEntity = salaryDbWrapper.get();
        assertEquals(empNo, salaryEntity.getEmpNo());
        assertEquals(fromDate, salaryEntity.getFromDate());
        assertEquals(60117, salaryEntity.getSalary());
        assertEquals(toDate, salaryEntity.getToDate());
    }

    @Test
    public void testFindAllSalaries() {
        Page<SalaryEntity> salariesPage = salaryRepository.findAll(PageRequest.of(0, 100));
        List<SalaryEntity> salaries = salariesPage.getContent();

        assertEquals(100, salaries.size());
    }
}
