package com.example.SeProject.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class LogoutController {

    @PostMapping("/api/logout")
    public ResponseEntity<String> logOut(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logout Success");
    }
}
