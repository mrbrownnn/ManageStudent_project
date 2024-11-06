package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.SubClass;
import com.example.studentbookingmanager.service.SubClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/SubClass")
@RequiredArgsConstructor
public class SubClassController {
    private final SubClassService subClassService;

    @PostMapping
    public ResponseEntity<SubClass> createSubClass(@RequestBody SubClass subClass) {
        return new ResponseEntity<>(subClassService.save(subClass), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<SubClass>> getAllSubClass() {
        return new ResponseEntity<>(subClassService.findAll(), HttpStatus.OK);
    }

    //lấy ra 1 student
    @GetMapping("/{id}")
    public ResponseEntity<SubClass> getSubClass(@PathVariable Long id) {
        Optional<SubClass> subClassOptional = subClassService.findById(id);
        return subClassOptional.map(subClass -> new ResponseEntity<>(subClass, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubClass> updateSubClass(@PathVariable Long id, @RequestBody SubClass subClass) {
        Optional<SubClass> subClassOptional = subClassService.findById(id);
        return subClassOptional.map(subClass1 -> {
            subClass.setId(subClass1.getId());
            return new ResponseEntity<>(subClassService.save(subClass), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubClass> deleteSubClass(@PathVariable Long id) {
        Optional<SubClass> subClassOptional = subClassService.findById(id);
        return subClassOptional.map(subClass -> {
            subClassService.remove(id);
            return new ResponseEntity<>(subClass, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
