package com.example.demologin2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping(value = {"/", "/home"})
    public String homepage(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
