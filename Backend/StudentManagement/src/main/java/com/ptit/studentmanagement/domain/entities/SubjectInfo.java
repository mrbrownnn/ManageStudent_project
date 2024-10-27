package com.ptit.studentmanagement.domain.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "subject_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SubjectInfo {
    @Id
    @Column(length = 20, unique = true)
    private String subjectId;
    @Column(length = 20)
    private String subjectName;
    @Column(length = 255)
    private String teacherName;
    @Column(length = 20)
    private Long credit;
    @Column(length = 20)
    private LocalDateTime startDate;
    @Column(length = 20)
    private LocalDateTime endDate;
    @Column(length = 20)
    private String room;
}
