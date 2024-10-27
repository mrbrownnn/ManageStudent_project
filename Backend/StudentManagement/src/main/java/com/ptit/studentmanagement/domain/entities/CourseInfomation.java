package com.ptit.studentmanagement.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course_infomation")
// display course infomation
public class CourseInfomation {
    @Id
    private String courseId;
    @Column(length = 30)
    private String courseName;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime endDate;
    @Column(length = 20)
    private String teacherName;
    @Column(length = 20)
    private String room;


}
