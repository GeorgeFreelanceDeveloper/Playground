package com.example.employeebackofficebe.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Integer empNo;

    @NotNull(message = "BirthDate cannot be null")
    @Schema(example = "1990-01-01")
    private LocalDate birthDate;

    @NotNull(message = "FirstName cannot be null")
    @Size(max = 14, message = "LastName has max 14 character")
    @Schema(type = "string", example = "Jan")
    private String firstName;

    @NotNull(message = "LastName cannot be null")
    @Size(max = 16, message = "LastName has max 16 character")
    @Schema(type = "string", example = "Novak")
    private String lastName;

    @NotNull(message = "Gender cannot be null")
    @Schema(example = "M")
    private Gender gender;

    @NotNull(message = "HireDate cannot be null")
    @Schema(example = "2010-01-01")
    private LocalDate hireDate;
}
