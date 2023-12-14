package org.example.data.repository;

import org.example.data.model.Enrolment;
import org.example.data.model.EnrolmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrolment, EnrolmentId> {
    List<Enrolment> findByStudentId(Long studentId);
}
