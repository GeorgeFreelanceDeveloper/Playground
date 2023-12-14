package com.example.employeebackofficebe.model.db.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptManagerKey implements Serializable {

    private String deptNo;

    private Integer empNo;
}
