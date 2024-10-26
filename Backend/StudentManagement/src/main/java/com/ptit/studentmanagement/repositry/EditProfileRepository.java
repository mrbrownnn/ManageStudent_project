package com.ptit.studentmanagement.repositry;

import com.ptit.studentmanagement.domain.entities.Students;
import com.ptit.studentmanagement.domain.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditProfileRepository extends JpaRepository<Students, Long> {
    Students findByStudentId(String studentId);

    @Override
    Optional<Students> findById(Long aLong);
}
