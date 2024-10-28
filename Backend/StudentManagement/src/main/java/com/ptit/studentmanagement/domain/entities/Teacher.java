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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String gender;
    private String address;
    private String phonenumber;
    private String specialize;
    private float salary;
    private String createdAt;
    private String updatedAt;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Collection<SubClass> subClass;
}
