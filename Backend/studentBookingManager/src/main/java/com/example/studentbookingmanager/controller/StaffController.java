package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.Staff;
import com.example.studentbookingmanager.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<Staff> createNewStaff(@RequestBody Staff staff) {
        return new ResponseEntity<>(staffService.save(staff), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Staff>> getAllStaff() {
        return new ResponseEntity<>(staffService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable Long id) {
        Optional<Staff> staffOptional = staffService.findById(id);
        return staffOptional.map(staff -> new ResponseEntity<>(staff, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        Optional<Staff> staffOptional = staffService.findById(id);
        return staffOptional.map(staff1 -> {
            staff.setId(staff.getId());
            return new ResponseEntity<>(staffService.save(staff), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> deleteStudents(@PathVariable Long id) {
        Optional<Staff> staffOptional = staffService.findById(id);
        return staffOptional.map(staff -> {
            staffService.remove(id);
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
