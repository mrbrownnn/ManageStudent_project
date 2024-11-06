package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.BookingSubject;
import com.example.studentbookingmanager.service.BookingSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/BookingSubject")
@RequiredArgsConstructor
public class BookingSubjectController {
    private final BookingSubjectService bookingSubjectService;

    @PostMapping
    public ResponseEntity<BookingSubject> createNewBookingSubject(@RequestBody BookingSubject bookingSubject) {
        return new ResponseEntity<>(bookingSubjectService.save(bookingSubject), HttpStatus.OK);
    }
    // lấy ra tất cả students
    @GetMapping
    public ResponseEntity<Iterable<BookingSubject>> getAllBookingSubject() {
        return new ResponseEntity<>(bookingSubjectService.findAll(), HttpStatus.OK);
    }

    //lấy ra 1 student
    @GetMapping("/{id}")
    public ResponseEntity<BookingSubject> getBookingSubject(@PathVariable Long id) {
        Optional<BookingSubject> bookingSubjectOptional = bookingSubjectService.findById(id);
        return bookingSubjectOptional.map(bookingSubject -> new ResponseEntity<>(bookingSubject, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingSubject> updateBookingSubject(@PathVariable Long id, @RequestBody BookingSubject
            bookingSubject) {
        Optional<BookingSubject> bookingSubjectOptional = bookingSubjectService.findById(id);
        return bookingSubjectOptional.map(bookingSubject1 -> {
            bookingSubject.setId(bookingSubject1.getId());
            return new ResponseEntity<>(bookingSubjectService.save(bookingSubject), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingSubject> deleteBookingSubject(@PathVariable Long id) {
        Optional<BookingSubject> bookingSubjectOptional = bookingSubjectService.findById(id);
        return bookingSubjectOptional.map(students -> {
            bookingSubjectService.remove(id);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
