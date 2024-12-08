package com.example.SeProject.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {
    public void logOut(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

}
