package com.ptit.studentmanagement.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Students {
    @Id
    @Column(length = 20, unique = true)
    private String studentId;
    // dinh dang st_id la string
    @Column(length = 100)
    private String studentName;
    @Column(length =255)
    private String address;
    @Column(length = 5)
    // D2024....
    private String courseYear;
    @Column(length = 100)
    private String Hometown;
    @Column
    private LocalDateTime dateOfBirth;
}
