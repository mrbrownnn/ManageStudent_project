package com.fpt.manage.Springboot_Manage_app.repository;


import com.fpt.manage.Springboot_Manage_app.domain.entrities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import java.util.Optional;
@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Role.RoleName roleName);
}
// need class include RoleName and Optinal<Role>
