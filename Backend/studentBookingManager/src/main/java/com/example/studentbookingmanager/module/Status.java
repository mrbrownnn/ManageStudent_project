package com.example.studentbookingmanager.module;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude

    private Collection<Students> students;

}
