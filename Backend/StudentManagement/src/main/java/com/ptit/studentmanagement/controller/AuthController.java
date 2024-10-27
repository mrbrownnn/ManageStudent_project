package com.ptit.studentmanagement.controller;

import com.ptit.studentmanagement.domain.payload.request.AccountRequest;
import com.ptit.studentmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add-student-account")
    public ResponseEntity<?> addStudentAccount(@RequestBody AccountRequest accountRequest) {
        accountService.addStudentAccount(accountRequest);
        return new ResponseEntity<>(accountRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/student-account")
    public ResponseEntity<?> getStudentAccount(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getStudentAccount(id), HttpStatus.OK);
    }
}
