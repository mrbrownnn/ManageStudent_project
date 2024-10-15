package com.fpt.manage.Springboot_Manage_app.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Courses {
    @Id
    @Column(length = 10)
    private String CourseId;
    @Column(length = 50)
    private String CourseName;
    private int Credit;
    private int semester;
}
