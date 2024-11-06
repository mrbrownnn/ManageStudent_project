package com.example.studentbookingmanager.service.imp;

import com.example.studentbookingmanager.module.Students;
import com.example.studentbookingmanager.repository.StudentsRepository;
import com.example.studentbookingmanager.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentsServiceImp implements StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    @Override
    public Iterable<Students> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public Optional<Students> findById(Long id) {
        return studentsRepository.findById(id);
    }

    @Override
    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    @Override
    public void remove(Long id) {
        studentsRepository.deleteById(id);
    }
}
