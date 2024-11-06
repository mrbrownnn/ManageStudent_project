package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.Teacher;
import com.example.studentbookingmanager.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> createNewTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Teacher>> getAllTeacher() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        return teacherOptional.map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        return teacherOptional.map(teacher1 -> {
            teacher.setId(teacher1.getId());
            return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id) {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        return teacherOptional.map(teacher -> {
            teacherService.remove(id);
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
