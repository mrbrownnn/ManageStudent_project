package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.Students;
import com.example.studentbookingmanager.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final StudentsService studentsService;

    @PostMapping
    public ResponseEntity<Students> createNewStudents(@RequestBody Students students) {
        return new ResponseEntity<>(studentsService.save(students), HttpStatus.OK);
    }
    // lấy ra tất cả students
    @GetMapping
    public ResponseEntity<Iterable<Students>> getAllStudents() {
        return new ResponseEntity<>(studentsService.findAll(), HttpStatus.OK);
    }

    //lấy ra 1 student
    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable Long id) {
        Optional<Students> studentsOptional = studentsService.findById(id);
        return studentsOptional.map(students -> new ResponseEntity<>(students, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudents(@PathVariable Long id, @RequestBody Students students) {
        Optional<Students> studentsOptional = studentsService.findById(id);
        return studentsOptional.map(students1 -> {
            students.setId(students1.getId());
            return new ResponseEntity<>(studentsService.save(students), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Students> deleteStudents(@PathVariable Long id) {
        Optional<Students> studentsOptional = studentsService.findById(id);
        return studentsOptional.map(students -> {
            studentsService.remove(id);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
