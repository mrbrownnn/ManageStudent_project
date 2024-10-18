package com.ptit.studentmanagement.repositry;

import com.ptit.studentmanagement.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditProfileRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(String studentId);

    @Override
    Optional<Student> findById(Long aLong);
}
