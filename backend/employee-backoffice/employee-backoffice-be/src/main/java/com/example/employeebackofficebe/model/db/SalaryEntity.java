package com.example.employeebackofficebe.model.db;

import com.example.employeebackofficebe.model.db.key.SalaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Salaries")
@IdClass(SalaryKey.class)
public class SalaryEntity {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("empNo")
    @JoinColumn(name = "emp_no")
    @EqualsAndHashCode.Exclude @ToString.Exclude private EmployeeEntity employee;

    public SalaryEntity(final Integer empNo, final Integer salary, final LocalDate fromDate, final LocalDate toDate) {
        this.empNo = empNo;
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
