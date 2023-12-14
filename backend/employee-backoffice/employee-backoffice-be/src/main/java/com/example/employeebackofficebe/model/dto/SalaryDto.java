package com.example.employeebackofficebe.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {

    @Schema(example = "10001")
    private Integer empNo;

    @NotNull(message = "Salary cannot be null")
    @Schema(example = "65000")
    private Integer salary;

    @NotNull(message = "FromDate cannot be null")
    @Schema(example = "2001-01-18")
    private LocalDate fromDate;

    @NotNull(message = "ToDate cannot be null")
    @Schema(example = "2003-08-03")
    private LocalDate toDate;
}
