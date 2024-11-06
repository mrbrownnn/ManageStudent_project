package com.example.demologin2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/student1")
    @PreAuthorize("hasRole('STUDENT1')")
    public String student1Access() {
        return "Student 1 Content.";
    }

    @GetMapping("/student2")
    @PreAuthorize("hasRole('STUDENT2')")
    public String student2Access() {
        return "Student 2 Board.";
    }

    @GetMapping("/student3")
    @PreAuthorize("hasRole('STUDENT3')")
    public String student3Access() {
        return "Student 3 Board.";
    }

    @GetMapping("/student4")
    @PreAuthorize("hasRole('STUDENT4')")
    public String student4Access() {
        return "Student 4 Board.";
    }
}
