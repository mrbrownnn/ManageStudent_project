package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "subClass")
    @EqualsAndHashCode.Exclude
    private Collection <BookingSubject> bookingSubject;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "idTeacher")
    private Teacher teacher;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "idSubjects")
    private Subject subject;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "idSchedule")
    private Schedule schedule;

    private String typeOfClass;
    private String startedDate;
    private String endedDate;




}
