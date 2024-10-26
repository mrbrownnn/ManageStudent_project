package com.ptit.studentmanagement.repositry;

import com.ptit.studentmanagement.domain.entities.Registation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Class, Long> {
    Optional<Class> findClassesByClassIdAndClassName(String classId, String className);
}
