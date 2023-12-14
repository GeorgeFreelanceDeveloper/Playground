package com.example.employeebackofficebe.model.db;

import com.example.employeebackofficebe.model.db.key.DeptManagerKey;
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
@Table(name = "dept_manager")
@IdClass(DeptManagerKey.class)
public class DeptManagerEntity {

    @Id
    @Column(name = "dept_no", columnDefinition = "CHAR(4)", nullable = false)
    private String deptNo;

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name = "emp_no")
    @EqualsAndHashCode.Exclude @ToString.Exclude private EmployeeEntity manager;

    @ManyToOne
    @MapsId("deptNo")
    @JoinColumn(name = "dept_no")
    @EqualsAndHashCode.Exclude @ToString.Exclude private DepartmentEntity department;

    @Column(nullable = false)
    private LocalDate fromDate;

    @Column(nullable = false)
    private LocalDate toDate;
}
