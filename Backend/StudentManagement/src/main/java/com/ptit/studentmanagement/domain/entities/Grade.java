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
    @Column(length = 20)
    private String classId;
    @Column(length = 20)
    private String semester;
    @Column(length = 5)
    private String year;
    private Double grade1;
    private Long grade1Weight;
    private Double grade2;
    private Long grade2Weight;
    private Double grade3;
    private Long grade3Weight;
    private Double grade4;
    private Long grade4Weight;
    private Double finalExam;
    private Long finalExamWeight;
    private Double finalGrade;
    private Boolean isPass;
    private void calculateFinalGrade() {

        finalGrade = (grade1 * grade1Weight + grade2 * grade2Weight + grade3 * grade3Weight + finalExam * finalExamWeight) / 100;
        if (finalGrade >= 5) {
            isPass = true;
        } else {
            isPass = false;
        }
    }
}
