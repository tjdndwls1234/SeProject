package com.example.SeProject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class SessionController {

    @GetMapping("/api/SessionCheck")
    public ResponseEntity<String> checkSession(HttpSession session) {
        if (session == null || session.getId() == null)
            return ResponseEntity.ok("No session");
        return ResponseEntity.ok("Yes session");
    }
}
