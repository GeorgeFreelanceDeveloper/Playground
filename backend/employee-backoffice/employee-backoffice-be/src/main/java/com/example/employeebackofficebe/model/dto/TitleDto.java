package com.example.employeebackofficebe.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitleDto {

    @Schema(example = "10001")
    private Integer empNo;

    @NotNull(message = "Title cannot be null")
    @Size(max = 50, message = "Title has max 50 character")
    @Schema(type = "string", example = "Senior Engineer")
    private String title;

    @NotNull(message = "FromDate cannot be null")
    @Schema(example = "2011-01-03")
    private LocalDate fromDate;

    @Schema(example = "2015-07-23")
    private LocalDate toDate;
}
