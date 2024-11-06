package com.example.studentbookingmanager.service.imp;

import com.example.studentbookingmanager.module.BookingSubject;
import com.example.studentbookingmanager.repository.BookingSubjectRepository;
import com.example.studentbookingmanager.service.BookingSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingSubjectServiceImp implements BookingSubjectService {
    @Autowired
    private BookingSubjectRepository bookingSubjectRepository;

    @Override
    public Iterable<BookingSubject> findAll() {
        return bookingSubjectRepository.findAll();
    }

    @Override
    public Optional<BookingSubject> findById(Long id) {
        return bookingSubjectRepository.findById(id);
    }

    @Override
    public BookingSubject save(BookingSubject bookingSubject) {
        return bookingSubjectRepository.save(bookingSubject);
    }

    @Override
    public void remove(Long id) {
        bookingSubjectRepository.deleteById(id);
    }
}
