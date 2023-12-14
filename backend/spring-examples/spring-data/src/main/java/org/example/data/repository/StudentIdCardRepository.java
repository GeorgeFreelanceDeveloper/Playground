package org.example.data.repository;

import org.example.data.model.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
}
