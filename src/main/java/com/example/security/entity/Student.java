package com.example.security.entity;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@EnableMethodSecurity
public class Student {

    @PreAuthorize("hasRole('ACADEMIC')")
    @GetMapping("/academic")
    public  String getMessage(){
        return "Hello,Academic";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> response(){
        return ResponseEntity.ok("Hello,User");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> responseEntity(){
        return ResponseEntity.ok("Hello,Admin");
    }
}
