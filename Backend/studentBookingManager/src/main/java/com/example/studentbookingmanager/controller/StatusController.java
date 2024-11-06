package com.example.studentbookingmanager.controller;

import com.example.studentbookingmanager.module.Status;
import com.example.studentbookingmanager.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Status")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        return new ResponseEntity<>(statusService.save(status), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Status>> getAllStatus() {
        return new ResponseEntity<>(statusService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatus(@PathVariable Long id) {
        Optional<Status> statusOptional = statusService.findById(id);
        return statusOptional.map(status -> new ResponseEntity<>(status, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        Optional<Status> statusOptional = statusService.findById(id);
        return statusOptional.map(status1 -> {
            status.setId(status1.getId());
            return new ResponseEntity<>(statusService.save(status), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status> deleteStatus(@PathVariable Long id) {
        Optional<Status> statusOptional = statusService.findById(id);
        return statusOptional.map(status -> {
            statusService.remove(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
