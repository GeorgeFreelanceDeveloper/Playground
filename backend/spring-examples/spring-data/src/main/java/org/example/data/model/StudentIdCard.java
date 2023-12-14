package org.example.data.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "student_id_card", uniqueConstraints = {@UniqueConstraint(name = "student_id_card_number_unique", columnNames = "card_number")})
public class StudentIdCard {
    @Id
    @SequenceGenerator(name = "student_card_id_sequence", sequenceName = "student_card_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "student_card_id_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "card_number", nullable = false, columnDefinition = "TEXT")
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_id_fk"))
    private Student student;

    public StudentIdCard() {
    }

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" + "id=" + id + ", cardNumber='" + cardNumber + '\'' + '}';
    }
}
