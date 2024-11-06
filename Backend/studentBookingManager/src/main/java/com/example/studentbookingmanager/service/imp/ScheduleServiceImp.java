package com.example.studentbookingmanager.service.imp;

import com.example.studentbookingmanager.module.Schedule;
import com.example.studentbookingmanager.repository.ScheduleRepository;
import com.example.studentbookingmanager.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleServiceImp implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Iterable<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void remove(Long id) {
        scheduleRepository.deleteById(id);
    }
}
