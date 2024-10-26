package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prequisite_course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PrequisiteCourse {
    @Id
    @Column(length = 20)
    private String courseId;
    @Column(length = 20)
    private Long prequisiteCourseId;

}
