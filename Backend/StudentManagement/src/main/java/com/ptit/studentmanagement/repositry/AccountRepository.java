package com.ptit.studentmanagement.repositry;

import com.ptit.studentmanagement.domain.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByStudentIdOrUsername(String studentId, String username);
}
