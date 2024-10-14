// UserService.java
package com.fpt.manage.Springboot_Manage_app.repository;

import com.fpt.manage.Springboot_Manage_app.payload.SignUpRequest;
import com.fpt.manage.Springboot_Manage_app.repository.RoleRepository;
import com.fpt.manage.Springboot_Manage_app.domain.entities.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private RoleRepository roleRepository;

    public boolean isAdminRole(String roleName) {
        return roleRepository.findByName(RoleName.valueOf(roleName)).orElse(null) == RoleName.ADMIN;
    }

    public void registerUser(SignUpRequest signUpRequest) {
        if (!isAdminRole(signUpRequest.getRole())) {
            throw new IllegalArgumentException("Only admin can be registered");
        }
        // existing registration logic
    }
}