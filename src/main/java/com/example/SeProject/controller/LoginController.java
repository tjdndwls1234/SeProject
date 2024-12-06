package com.example.SeProject.controller;

import com.example.SeProject.dto.StudentLogInDto;
import com.example.SeProject.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    //로그인
    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody StudentLogInDto studentLogInDto, HttpSession session) {
        String result = loginService.logIn(studentLogInDto.getId(), studentLogInDto.getPw());

        if ("로그인 성공".equals(result)) {
            session.setAttribute("loggedInUser", studentLogInDto.getId());    //세션에 사용자ID 저장
            return ResponseEntity.ok("Login Success");
        } else {
            return ResponseEntity.badRequest().body("입력하신 아이디 또는 비밀번호가 올바르지 않습니다");   //로그인 실패 시
        }
    }
}
