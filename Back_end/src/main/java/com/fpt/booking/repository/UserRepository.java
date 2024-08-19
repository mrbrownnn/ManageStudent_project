package com.fpt.booking.repository;


import com.fpt.booking.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByPhone(String phone)    ;

    Optional<User> findByEmail(String email);

    Boolean existsByPhone(String phone);

    List<User> findByName(String name);

    long count();


}
