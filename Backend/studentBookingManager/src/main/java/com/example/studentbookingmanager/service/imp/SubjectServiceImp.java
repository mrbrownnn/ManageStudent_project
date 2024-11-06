package com.example.studentbookingmanager.service.imp;

import com.example.studentbookingmanager.module.Subject;
import com.example.studentbookingmanager.repository.SubjectRepository;
import com.example.studentbookingmanager.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectServiceImp implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void remove(Long id) {
        subjectRepository.deleteById(id);
    }
}
