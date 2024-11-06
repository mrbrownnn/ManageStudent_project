package com.example.demologin2.security.service;

import com.example.demologin2.models.Students;
import com.example.demologin2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentsDetailsServiceImpl implements UserDetailsService {

    @Autowired
    StudentsRepository studentsRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Students students = studentsRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Student not found with username"+username));

        return StudentsDetailsImpl.build(students);
    }
}
