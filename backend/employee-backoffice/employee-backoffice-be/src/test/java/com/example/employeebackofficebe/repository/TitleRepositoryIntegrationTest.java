package com.example.employeebackofficebe.repository;

import com.example.employeebackofficebe.model.db.TitleEntity;
import com.example.employeebackofficebe.model.db.key.TitleKey;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class TitleRepositoryIntegrationTest {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void testLoadTitle() {
        Integer empNo = 10001;
        LocalDate fromDate = LocalDate.of(1986, 6, 26);
        LocalDate toDate = LocalDate.of(9999, 1, 1);
        String title = "Senior Engineer";

        Optional<TitleEntity> titleDbWrapper = titleRepository.findById(new TitleKey(empNo,title, fromDate));
        assertTrue(titleDbWrapper.isPresent());

        TitleEntity titleEntity = titleDbWrapper.get();
        assertEquals(empNo, titleEntity.getEmpNo());
        assertEquals(title, titleEntity.getTitle());
        assertEquals(fromDate, titleEntity.getFromDate());
        assertEquals(toDate, titleEntity.getToDate());
    }

    @Test
    public void testFindAllTitles() {
        List<TitleEntity> titles = titleRepository.findAll();
        assertEquals(443308, titles.size());
    }

}
