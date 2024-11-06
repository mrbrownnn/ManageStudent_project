package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.Subject;
import com.example.studentbookingmanager.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> createNewSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    //lấy ra 1 student
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long id) {
        Optional<Subject> subjectOptional = subjectService.findById(id);
        return subjectOptional.map(subject -> new ResponseEntity<>(subject, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        Optional<Subject> subjectOptional = subjectService.findById(id);
        return subjectOptional.map(subject1 -> {
            subject.setId(subject1.getId());
            return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id) {
        Optional<Subject> subjectOptional = subjectService.findById(id);
        return subjectOptional.map(subject -> {
            subjectService.remove(id);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
