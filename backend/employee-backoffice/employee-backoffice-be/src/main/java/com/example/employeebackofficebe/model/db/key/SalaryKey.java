package com.example.employeebackofficebe.model.db.key;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryKey implements Serializable {
    private Integer empNo;
    private LocalDate fromDate;
}
