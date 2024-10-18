package com.ptit.studentmanagement.repositry;

import com.ptit.studentmanagement.domain.entities.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    Optional<Classes> findClassesByClassIdAndClassName(String classId, String className);
}
