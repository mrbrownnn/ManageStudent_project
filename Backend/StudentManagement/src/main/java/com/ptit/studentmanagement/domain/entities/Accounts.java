package com.ptit.studentmanagement.domain.entities;

import com.ptit.studentmanagement.domain.enums.RoleName;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(length = 20 , unique = true)
    private String username;
    @Column(length = 255)
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleName role;
}
