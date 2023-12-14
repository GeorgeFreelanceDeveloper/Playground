package com.example.employeebackofficebe.controller;

import com.example.employeebackofficebe.model.dto.*;
import com.example.employeebackofficebe.model.dto.EmployeeDto;
import com.example.employeebackofficebe.service.EmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee-backoffice-api/v1/employees")
public class EmployeesController {

    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_SIZE = 10;

    private final EmployeesService employeesService;


    @Autowired
    public EmployeesController(final EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @Operation(summary = "Add new employee", description = "Add new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PostMapping
    public Integer createEmployee(@NotNull @Valid @RequestBody final EmployeeDto employeeDto) {
        Integer id = employeesService.create(employeeDto);
        return id;
    }

    @Operation(summary = "Returns employees", description = "Returns employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    }
    )
    @GetMapping
    public List<EmployeeDto> getEmployees(@RequestParam(required = false) final Integer page, @RequestParam(required = false) final Integer size) {
        return employeesService.getAll(
                page == null ? DEFAULT_PAGE : page,
                size == null ? DEFAULT_SIZE : size);
    }

    @Operation(summary = "Get employee", description = "Get employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @GetMapping(path = "/{id}")
    public EmployeeDto getEmployee(@PathVariable final Integer id) {
        return employeesService.getById(id);
    }

    @Operation(summary = "Update employee", description = "Update employee data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PutMapping(path = "/{id}")
    public void updateEmployee(@PathVariable final Integer id, @NotNull @Valid @RequestBody final EmployeeDto employeeDto) {
        employeeDto.setEmpNo(id);
        employeesService.update(employeeDto);
    }

    @Operation(summary = "Delete employee", description = "Delete employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable final Integer id) {
        employeesService.deleteById(id);
    }

    @Operation(summary = "Get employee titles", description = "Get all employee titles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
    })
    @GetMapping(path = "/{id}/titles")
    public List<TitleDto> getEmployeeTitles(@PathVariable final Integer id) {
        return employeesService.getAllTitles(id);
    }

    @Operation(summary = "Create employee title", description = "Create employee title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PostMapping(path = "{id}/titles")
    public TitleId createEmployeeTitle(@PathVariable(name = "id") final Integer empNo, @NotNull @Valid @RequestBody final TitleDto titleDto) {
        titleDto.setEmpNo(empNo);
        return employeesService.createTitle(titleDto);
    }

    @Operation(summary = "Update employee title", description = "Update employee title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PutMapping(path = "{id}/titles")
    public void updateEmployeeTitle(@PathVariable(name = "id") final Integer empNo, @NotNull @Valid @RequestBody final TitleDto titleDto) {
        titleDto.setEmpNo(empNo);
        employeesService.updateTitle(titleDto);
    }

    @Operation(summary = "Delete employee title", description = "Delete employee title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping("{id}/titles")
    public void deleteEmployeeTitle(@NotNull @Valid @RequestBody final TitleId titleId) {
        employeesService.deleteTitle(titleId);
    }

    @Operation(summary = "Get employee salaries", description = "Get all employee salaries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
    })
    @GetMapping("{id}/salaries")
    public List<SalaryDto> getEmployeeSalaries(@PathVariable final Integer id) {
        return employeesService.getAllSalaries(id);
    }

    @Operation(summary = "Create employee salary", description = "Create employee salary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PostMapping("{id}/salaries")
    public SalaryId createEmployeeSalary(@PathVariable(name = "id") final Integer empNo, @NotNull @Valid @RequestBody final SalaryDto salaryDto) {
        salaryDto.setEmpNo(empNo);
        return employeesService.createSalary(salaryDto);
    }

    @Operation(summary = "Update employee salary", description = "Update employee salary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PutMapping("{id}/salaries")
    public void updateEmployeeSalary(@PathVariable(name = "id") final Integer empNo, @NotNull @Valid @RequestBody final SalaryDto salaryDto) {
        salaryDto.setEmpNo(empNo);
        employeesService.updateSalary(salaryDto);
    }

    @Operation(summary = "Delete employee salary", description = "Delete employee salary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping("{id}/salaries")
    public void deleteEmployeeSalary(@NotNull @Valid @RequestBody final SalaryId salaryId) {
        employeesService.deleteSalary(salaryId);
    }
}
