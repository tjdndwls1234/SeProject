package com.example.SeProject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping
@RestController
public class SessionController {

    @GetMapping("/api/SessionCheck")
    public ResponseEntity<Map<String, String>> checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Map<String, String> response = new HashMap<>();
        if (session == null || (session.getAttribute("StudentCode") == null))
            response.put("sessionStatus", "No session");
        else response.put("sessionStatus", "Yes session");

        return ResponseEntity.ok(response);
    }
}
