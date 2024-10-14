package com.fpt.manage.Springboot_Manage_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import java.util.Optional;
import com.fpt.manage.Springboot_Manage_app.domain.entities.Role;
import com.fpt.manage.Springboot_Manage_app.domain.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
<<<<<<< HEAD
    Optional<Role> findByName(RoleName roleName);
}
// need class include RoleName and Optinal<Role>
=======
    Optional<Role> findByName(RoleName name);
}
>>>>>>> 60ad27914cbaea40a5bd1d2e0d19ab18a38acb8c
