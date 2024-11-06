package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
