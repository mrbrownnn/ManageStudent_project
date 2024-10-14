
package com.fpt.manage.Springboot_Manage_app.domain.entrities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends DateAudit{
    @ManyToMany(mappedBy = "role")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public enum RoleName {
        ADMIN
    }

    private static GeneratedValue GeneratedValue(GenerationType identity) {
        return null;
    }
}

