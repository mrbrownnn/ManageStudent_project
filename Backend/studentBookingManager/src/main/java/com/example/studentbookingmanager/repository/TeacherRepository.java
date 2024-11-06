package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
