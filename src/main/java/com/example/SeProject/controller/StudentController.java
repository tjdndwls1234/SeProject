package com.example.SeProject.controller;

import com.example.SeProject.dto.StudentLogInDto;
import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody StudentSignUpDto studentSignUpDto) {
        String result = studentService.signUp(studentSignUpDto);
        if ("중복되는 아이디입니다.".equals(result)) {
            return ResponseEntity.badRequest().body("중복되는 아이디입니다.");
        }
        //회원가입 후 로그인 페이지로 리디렉션
        return ResponseEntity.ok("Sign Up Success");
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody StudentLogInDto studentLogInDto) {
        String result = studentService.logIn(studentLogInDto.getId(), studentLogInDto.getPw());

        if ("로그인 성공".equals(result)) {
            return ResponseEntity.ok("Login Success");    //로그인 성공 시 홈페이지로 리디렉션
        }
        else {
            return ResponseEntity.badRequest().body("입력하신 아이디 또는 비밀번호가 올바르지 않습니다");   //로그인 실패 시 에러 메시지와 함께 로그인 페이지로 리디렉션
        }
    }

}
