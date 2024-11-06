package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long> {
}
