package com.example.SeProject.controller;

import com.example.SeProject.dto.StudentLogInDto;
import com.example.SeProject.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    //로그인
    @PostMapping("/api/login")
    public ResponseEntity<String> logIn(@RequestBody StudentLogInDto studentLogInDto, HttpSession session) {
        String result = loginService.logIn(studentLogInDto.getId(), studentLogInDto.getPw());

        System.out.println(result);
        if (result.equals("로그인 성공")) {
            String studentCode = loginService.getStudentCode(studentLogInDto.getId());
            session.setAttribute("StudentCode", studentCode);
            return ResponseEntity.ok("Login Success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디나 비밀번호가 올바르지 않습니다.");
        }
    }
}
