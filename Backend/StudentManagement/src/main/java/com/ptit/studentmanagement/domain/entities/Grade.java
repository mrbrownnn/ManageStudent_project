package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grade {
    @Id
        private String studentId;
    @Column(length = 20, unique = true)
        private String classId;
    @Column(length = 5)
        private String semester;
    @Column(length = 5)
        private String year;
    @Column(length = 5)
        private Double grade1;
    @Column(length = 2)
        private Long grade1Weight;
    @Column(length = 2)
        private Double grade2;
    @Column(length = 2)
        private Long grade2Weight;
    @Column(length = 2)
        private Double grade3;
    @Column(length = 2)
        private Long grade3Weight;
    @Column(length = 2)
        private Double grade4;
    @Column(length = 2)
        private Long grade4Weight;
    @Column(length = 2)
        private Double finalExam;
    @Column(length = 2)
        private Long finalExamWeight;
    @Column(length = 2)
        private Double finalGrade;
    @Column(unique = true)
        private Boolean isPass;
    private void calculateFinalGrade() {
        finalGrade = (grade1 * grade1Weight + grade2 * grade2Weight + grade3 * grade3Weight + finalExam * finalExamWeight) / 100;
        System.out.println("Final grade: " + finalGrade);
        if(finalGrade >= 4.0) {
            isPass = true;
        } else {
            isPass = false;
        }
    }
}
