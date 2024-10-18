package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prerequisite_courses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrerequisiteCourses {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name ="course_id")
    private Courses courses;
    @ManyToOne
    @JoinColumn(name = "prerequisite_course_id")
    private Courses prerequisiteCourseId;
}