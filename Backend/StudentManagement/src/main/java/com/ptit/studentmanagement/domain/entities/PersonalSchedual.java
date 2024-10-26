package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personal_schedual")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(PersonalSchedualPrimaryKey.class)
public class PersonalSchedual {
    @Id
    private String studentId;
    private String courseId;
    private String classId;
    private String semesterId;
    // to chuc thanh sieu khoa
}
