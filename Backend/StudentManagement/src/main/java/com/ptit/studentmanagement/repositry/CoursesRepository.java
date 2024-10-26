package com.ptit.studentmanagement.repositry;

import com.ptit.studentmanagement.domain.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Grade, Long> {

}
