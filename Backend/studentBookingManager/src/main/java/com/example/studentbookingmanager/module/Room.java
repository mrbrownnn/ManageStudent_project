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
public class Room {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
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
