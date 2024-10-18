package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(length = 10)
    private String studentId;

    @Column(length = 100)
    private String studentName;
    @Column
    private LocalDateTime birthdate;

    @Column(length = 3)
    private String courseYear;

    @Column(length = 100)
    private String hometown;

    @Column(length = 255)
    private String address;
}