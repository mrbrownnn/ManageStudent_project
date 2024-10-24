package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    @Id
    @Column(length = 20)
    private String classId;
    @ManyToOne
    @JoinColumn(name ="course_id")
    @Column(length = 20)
    private Courses courseId;

    @Column(length = 100)
    private String className;

    @Column
    private int maxStudent;

    @Column(length = 50)
    private String room;

    @Column(length = 20)
    private String dayOfWeek;

    @Column(length = 20)
    private String timeRange;

}