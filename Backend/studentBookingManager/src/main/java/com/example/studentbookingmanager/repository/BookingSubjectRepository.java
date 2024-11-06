package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.BookingSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSubjectRepository extends JpaRepository<BookingSubject, Long> {
}
