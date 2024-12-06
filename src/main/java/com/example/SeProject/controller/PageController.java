package com.example.SeProject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String redirectBasedOnSession(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("studentCode") == null) {
            return "redirect:/login";
        }

        return "redirect:/MainPage";
    }

    @GetMapping("/login")
    public String showLoginPage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        // 이미 로그인된 사용자가 로그인 페이지에 접근하려고 하면 메인 페이지로 리다이렉트
        if (session != null && session.getAttribute("studentCode") != null) {
            return "redirect:/MainPage";
        }

        return "login";
    }
}
