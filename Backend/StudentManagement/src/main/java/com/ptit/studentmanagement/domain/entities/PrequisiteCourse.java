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
    @ManyToMany(mappedBy = "courseId")
    private String courseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prequisiteCourseId;
    @Column(length = 20)
    private boolean Status;

}
