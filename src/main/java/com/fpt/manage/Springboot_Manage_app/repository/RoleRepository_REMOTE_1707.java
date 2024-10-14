package com.fpt.manage.Springboot_Manage_app.repository;


import com.fpt.manage.Springboot_Manage_app.domain.entrities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.fpt.manage.Springboot_Manage_app.domain.entities.Accounts;
import com.fpt.manage.Springboot_Manage_app.domain.entities.RoleName;

public interface RoleRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByName(RoleName name);
}