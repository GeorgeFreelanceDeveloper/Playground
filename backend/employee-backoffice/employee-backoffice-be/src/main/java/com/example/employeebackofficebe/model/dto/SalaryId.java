package com.example.employeebackofficebe.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryId {

    @NotNull(message = "Employee Id cannot be null")
    private Integer empNo;

    @NotNull(message = "FromDate cannot be null")
    private LocalDate fromDate;
}
