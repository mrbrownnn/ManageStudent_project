
package com.ptit.studentmanagement.domain.entities;

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
    private String courseId;
    @Column(length = 50)
    private String courseName;
    private int credit;
    private int semester;

}
