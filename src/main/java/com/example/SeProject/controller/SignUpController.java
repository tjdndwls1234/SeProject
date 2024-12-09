package com.example.SeProject.controller;

import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/signup")
@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final SignUpService signUpService;

    //회원가입
    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody StudentSignUpDto studentSignUpDto) {
        System.out.println(studentSignUpDto.getDepartmentCode());
        String result = signUpService.signUp(studentSignUpDto);
        if ("중복되는 아이디입니다.".equals(result)) {
            return ResponseEntity.ok().body("중복되는 아이디입니다.");
        }
        return ResponseEntity.ok("Sign Up Success");
    }

}
