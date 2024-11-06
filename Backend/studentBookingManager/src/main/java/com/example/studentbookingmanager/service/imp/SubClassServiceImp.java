package com.example.studentbookingmanager.service.imp;

import com.example.studentbookingmanager.module.SubClass;
import com.example.studentbookingmanager.repository.SubClassRepository;
import com.example.studentbookingmanager.service.SubClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubClassServiceImp implements SubClassService {
    @Autowired
    private SubClassRepository subClassRepository;

    @Override
    public Iterable<SubClass> findAll() {
        return subClassRepository.findAll();
    }

    @Override
    public Optional<SubClass> findById(Long id) {
        return subClassRepository.findById(id);
    }

    @Override
    public SubClass save(SubClass subClass) {
        return subClassRepository.save(subClass);
    }

    @Override
    public void remove(Long id) {
        subClassRepository.deleteById(id);
    }
}
