package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
