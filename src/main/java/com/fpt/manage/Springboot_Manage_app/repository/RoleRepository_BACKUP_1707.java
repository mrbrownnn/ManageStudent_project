package com.fpt.manage.Springboot_Manage_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.fpt.manage.Springboot_Manage_app.domain.entities.Accounts;
import com.fpt.manage.Springboot_Manage_app.domain.entities.RoleName;

public interface RoleRepository extends JpaRepository<Accounts, Long> {
<<<<<<< HEAD
    Optional<Accounts> findByName(RoleName roleName);
}
// need class include RoleName and Optinal<Role>
=======
    Optional<Accounts> findByName(RoleName name);
}
>>>>>>> 60ad27914cbaea40a5bd1d2e0d19ab18a38acb8c
