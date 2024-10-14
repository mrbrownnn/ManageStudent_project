/*
package com.fpt.manage.Springboot_Manage_app.domain.entrities;


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
public class Role {
    @ManyToMany(mappedBy = "roles")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ;
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;
    private static GeneratedValue GeneratedValue(GenerationType identity) {
        return null;
    }
    }
}

 */
