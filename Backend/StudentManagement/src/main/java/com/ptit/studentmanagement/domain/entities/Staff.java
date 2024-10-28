package com.ptit.studentmanagement.domain.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String gender;
    private String address;
    private String phonenumber;
    private String role;
    private float salary;
    private String createdAt;
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "idStaff")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Schedule schedule;
}
