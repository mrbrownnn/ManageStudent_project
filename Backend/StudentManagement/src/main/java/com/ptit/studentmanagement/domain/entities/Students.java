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
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String gender;
    private String address;
    private String email;
    private String password;
    private String phonenumber;
    private String createdAt;
    private String updatedAt;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private com.example.studentbookingmanager.module.Status status;

    @ManyToMany(mappedBy = "students")
    @EqualsAndHashCode.Exclude
    private Collection<BookingSubject> bookingSubjects;
}
