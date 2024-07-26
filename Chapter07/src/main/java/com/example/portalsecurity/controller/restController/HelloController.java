package com.example.portalsecurity.controller.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //start 7.1.1
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
    //end 7.1.1
}