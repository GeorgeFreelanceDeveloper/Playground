package com.example.employeebackofficebe.model.db;

import com.example.employeebackofficebe.model.db.key.TitleKey;
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
@Table(name = "titles")
@IdClass(TitleKey.class)
public class TitleEntity {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Id
    @Column(name = "title", columnDefinition = "VARCHAR(50)", nullable = false)
    private String title;

    @Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("empNo")
    @JoinColumn(name = "emp_no")
    @EqualsAndHashCode.Exclude @ToString.Exclude private EmployeeEntity employee;

    public TitleEntity(final Integer empNo, final String title, final LocalDate fromDate, final LocalDate toDate) {
        this.empNo = empNo;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
