package com.example.studentbookingmanager.module;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idRoom")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Room room;
    private String startedAt;
    private String endedAt;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private Collection<Staff> staff;

}
