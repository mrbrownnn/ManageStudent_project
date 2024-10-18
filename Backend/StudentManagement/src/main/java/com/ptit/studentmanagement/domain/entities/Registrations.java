package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registrations")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(RegistrationsPrimaryKey.class)
public class Registrations {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;
    @Id
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classId;

    private double grade1;
    private double grade1Weight;
    private double grade2;
    private double grade2Weight;
    private double grade3;
    private double grade3Weight;
    private double finalExam;
    private double finalExamWeight;
    private double finalGrade;
}