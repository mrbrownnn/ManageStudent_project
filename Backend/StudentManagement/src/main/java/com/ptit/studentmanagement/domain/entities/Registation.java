package com.ptit.studentmanagement.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "registation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(RegistationPrimaryKey.class)
public class Registation {
    @Id
    private String studentId;
    private String prequisiteId;
    @Column(length=20, unique = true)
    private String classId;
    @Column(length = 20)
    private String idSubject;
    @Column
    private String semester;
    @Column(length = 20)
    private String year;
    @Column(length = 20)
    private LocalDateTime LearningDate;
    @Column(length = 20)
    private Long maxStudent;
    @Column(length = 20)
    private Long currentStudent;
    @Column
    private Boolean status;
    // checking if student is pass or not or checking click in GUI register
}
