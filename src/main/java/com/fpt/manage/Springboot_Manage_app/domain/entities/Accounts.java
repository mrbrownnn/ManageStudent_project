package com.fpt.manage.Springboot_Manage_app.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;
    @Column(unique = true, length = 50)
    private Long username;
    @Column(length = 255)
    private Long password;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private com.fpt.manage.Springboot_Manage_app.domain.entities.RoleName role;
}
