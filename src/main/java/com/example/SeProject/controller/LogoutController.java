package com.example.SeProject.controller;

import com.example.SeProject.service.LogoutService;
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
    public final LogoutService logoutService;

    @PostMapping("/logout")
    public ResponseEntity<String> logOut(HttpSession session) {
        logoutService.logOut(session);  //세션 무효화
        return ResponseEntity.ok("Logout Success");
    }

}
