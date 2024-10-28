package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;
    private String description;
    private int theorySessionNumber;
    private int practiceSessionNumber;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Collection<SubClass> subClass;
}
