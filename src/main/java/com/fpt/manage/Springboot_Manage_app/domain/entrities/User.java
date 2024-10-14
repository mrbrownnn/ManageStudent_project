
/*
package com.fpt.manage.Springboot_Manage_app.domain.entrities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.Id;
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends DateAudit {
    @ManyToMany(mappedBy = "roles")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private String id;

    private Role name;
    private static GeneratedValue GeneratedValue(GenerationType identity) {
        return null;
    }
}
*/
