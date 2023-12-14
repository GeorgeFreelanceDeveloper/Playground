package com.example.employeebackofficebe.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitleId {

    @NotNull(message = "Employee Id cannot be null")
    private Integer empNo;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "FromDate cannot be null")
    private LocalDate fromDate;
}
