package com.example.employeebackofficebe.service;

import com.example.employeebackofficebe.mapper.EmployeeDbMapper;
import com.example.employeebackofficebe.mapper.SalaryDbMapper;
import com.example.employeebackofficebe.mapper.TitleDbMapper;
import com.example.employeebackofficebe.model.db.*;
import com.example.employeebackofficebe.model.db.EmployeeEntity;
import com.example.employeebackofficebe.model.db.key.SalaryKey;
import com.example.employeebackofficebe.model.db.key.TitleKey;
import com.example.employeebackofficebe.model.dto.*;
import com.example.employeebackofficebe.model.dto.EmployeeDto;
import com.example.employeebackofficebe.repository.EmployeeRepository;
import com.example.employeebackofficebe.repository.SalaryRepository;
import com.example.employeebackofficebe.repository.TitleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesService {

    private final EmployeeRepository employeeRepository;
    private final TitleRepository titleRepository;

    private final SalaryRepository salaryRepository;

    public EmployeesService(final EmployeeRepository employeeRepository,
                            final TitleRepository titleRepository,
                            final SalaryRepository salaryRepository) {
        this.employeeRepository = employeeRepository;
        this.titleRepository = titleRepository;
        this.salaryRepository = salaryRepository;
    }

    public Integer create(final EmployeeDto employeeDto) {
        EmployeeEntity employeeDb = EmployeeDbMapper.MAPPER.toEmployeeDb(employeeDto);
        return employeeRepository.save(employeeDb).getEmpNo();
    }

    public List<EmployeeDto> getAll(final Integer page, final Integer size) {
        List<EmployeeEntity> employeeDbs = employeeRepository.findAll(PageRequest.of(page, size)).getContent();
        return EmployeeDbMapper.MAPPER.fromEmployeesDb(employeeDbs);
    }

    public EmployeeDto getById(final Integer id) {
        Optional<EmployeeEntity> employeeDbWrapper = employeeRepository.findById(id);

        if (employeeDbWrapper.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Employee with ID %s not found", id));
        }

        return EmployeeDbMapper.MAPPER.fromEmployeeDb(employeeDbWrapper.get());
    }

    public void update(final EmployeeDto employeeDto) {
        Optional<EmployeeEntity> employeeDbWrapper = employeeRepository.findById(employeeDto.getEmpNo());

        if (employeeDbWrapper.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Employee with ID %s not found", employeeDto.getEmpNo()));
        }

        EmployeeEntity employeeDbInDatabase = employeeDbWrapper.get();
        EmployeeEntity employeeDb = EmployeeDbMapper.MAPPER.toEmployeeDb(employeeDto);

        if (employeeDb.getBirthDate() != null) {
            employeeDbInDatabase.setBirthDate(employeeDb.getBirthDate());
        }

        if (employeeDb.getFirstName() != null) {
            employeeDbInDatabase.setFirstName(employeeDb.getFirstName());
        }

        if (employeeDb.getLastName() != null) {
            employeeDbInDatabase.setLastName(employeeDb.getLastName());
        }

        if (employeeDb.getGender() != null) {
            employeeDbInDatabase.setGender(employeeDb.getGender());
        }

        if (employeeDb.getHireDate() != null) {
            employeeDbInDatabase.setHireDate(employeeDb.getHireDate());
        }

        employeeRepository.save(employeeDbInDatabase);
    }

    public void deleteById(final Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<TitleDto> getAllTitles(final Integer empNo) {
        return titleRepository.findByEmpNo(empNo)
                .stream()
                .map(titleDb -> TitleDbMapper.MAPPER.fromTitleDb(titleDb))
                .sorted((title1, title2) -> title1.getFromDate().compareTo(title2.getFromDate()))
                .collect(Collectors.toList());
    }

    public TitleId createTitle(final TitleDto titleDto) {
        TitleEntity titleEntity = TitleDbMapper.MAPPER.toTitleDb(titleDto);
        TitleEntity result = titleRepository.save(titleEntity);

        return new TitleId(result.getEmpNo(), result.getTitle(), result.getFromDate());
    }

    public void updateTitle(final TitleDto titleDto) {
        TitleKey titleKey = new TitleKey(titleDto.getEmpNo(), titleDto.getTitle(), titleDto.getFromDate());
        Optional<TitleEntity> titleDbWrapper = titleRepository.findById(titleKey);

        if (titleDbWrapper.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Employee with ID %s not found", titleDto.getEmpNo()));
        }

        TitleEntity titleEntity = titleDbWrapper.get();
        titleEntity.setToDate(titleDto.getToDate());
        titleRepository.save(titleEntity);
    }

    public void deleteTitle(final TitleId titleId) {
        final TitleEntity titleEntity = new TitleEntity();

        titleEntity.setEmpNo(titleId.getEmpNo());
        titleEntity.setTitle(titleId.getTitle());
        titleEntity.setFromDate(titleId.getFromDate());

        titleRepository.delete(titleEntity);
    }

    public List<SalaryDto> getAllSalaries(final Integer empNo) {
        return salaryRepository.findByEmpNo(empNo)
                .stream()
                .map(salaryDb -> SalaryDbMapper.MAPPER.fromSalaryDb(salaryDb))
                .collect(Collectors.toList());
    }

    public SalaryId createSalary(final SalaryDto salaryDto) {
        SalaryEntity salaryEntity = SalaryDbMapper.MAPPER.toSalaryDb(salaryDto);
        SalaryEntity result = salaryRepository.save(salaryEntity);

        return new SalaryId(result.getEmpNo(), result.getFromDate());
    }

    public void updateSalary(final SalaryDto salaryDto) {
        SalaryKey salaryKey = new SalaryKey(salaryDto.getEmpNo(), salaryDto.getFromDate());
        Optional<SalaryEntity> salaryDbWrapper = salaryRepository.findById(salaryKey);

        if (salaryDbWrapper.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Employee with ID %s not found", salaryDto.getEmpNo()));
        }

        SalaryEntity salaryEntity = salaryDbWrapper.get();
        salaryEntity.setToDate(salaryDto.getToDate());
        salaryEntity.setSalary(salaryDto.getSalary());
        salaryRepository.save(salaryEntity);
    }

    public void deleteSalary(final SalaryId salaryId) {
        final SalaryEntity salaryEntity = new SalaryEntity();

        salaryEntity.setEmpNo(salaryId.getEmpNo());
        salaryEntity.setFromDate(salaryId.getFromDate());

        salaryRepository.delete(salaryEntity);
    }
}
