package com.example.studentbookingmanager.service.imp;

import com.example.studentbookingmanager.module.Status;
import com.example.studentbookingmanager.repository.StatusResponsitory;
import com.example.studentbookingmanager.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImp implements StatusService {
    @Autowired
    private StatusResponsitory statusResponsitory;


    @Override
    public Iterable<Status> findAll() {
        return statusResponsitory.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusResponsitory.findById(id);
    }

    @Override
    public Status save(Status status) {
        return statusResponsitory.save(status);
    }

    @Override
    public void remove(Long id) {
        statusResponsitory.deleteById(id);
    }
}
