package com.example.demologin2.repository;

import com.example.demologin2.models.ERoles;
import com.example.demologin2.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRespository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName (ERoles name);
}
