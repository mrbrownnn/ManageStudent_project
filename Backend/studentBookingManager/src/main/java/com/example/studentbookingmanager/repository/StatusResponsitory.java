package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusResponsitory extends JpaRepository <Status, Long>{
}
