package com.example.employeebackofficebe.model.db;

import com.example.employeebackofficebe.model.db.key.DeptEmpKey;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "dept_emp")
@IdClass(DeptEmpKey.class)
public class DeptEmpEntity {

    @Id
    @Column(name = "dept_no", columnDefinition = "CHAR(4)", nullable = false)
    private String deptNo;

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name = "emp_no")
    @EqualsAndHashCode.Exclude @ToString.Exclude private EmployeeEntity deptEmployee;

    @ManyToOne
    @MapsId("deptNo")
    @JoinColumn(name = "dept_no")
    @EqualsAndHashCode.Exclude @ToString.Exclude private DepartmentEntity department;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;
}
