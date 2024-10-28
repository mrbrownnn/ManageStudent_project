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
public class Room {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeOfRoom;
    private String buildingName;
    private int floor;
    private int roomNo;
    private int numberOfSeat;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Collection<Schedule> schedule;
}
