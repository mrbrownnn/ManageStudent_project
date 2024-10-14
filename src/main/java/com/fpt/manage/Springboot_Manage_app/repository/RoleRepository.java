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
import com.fpt.manage.Springboot_Manage_app.domain.entities.Role;
import com.fpt.manage.Springboot_Manage_app.domain.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}