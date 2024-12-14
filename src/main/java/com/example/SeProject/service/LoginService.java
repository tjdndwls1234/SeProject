package com.example.SeProject.service;

import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final StudentMapper studentMapper;

    //로그인 처리
    public boolean isLoggedIn(String id, String pw) {

        StudentSignUpDto student = studentMapper.logIn(id,pw);

        //student존재X : ID 존재X or 비번 안맞으면 실패f
        if (student == null) {
            return false;

        }
        //student존재O : 비번 일치하면 t, 실패하면 f
        return student.getPw().equals(pw);

    }

    public String logIn(String id, String pw) {
        if (isLoggedIn(id,pw)) {
            return "로그인 성공";       //메시지 처리 어떻게 할 지
        }
        else {
            return "입력하신 아이디 또는 비밀번호가 올바르지 않습니다";
        }
    }
    public String getStudentCode(String id){
        return studentMapper.getStudentCode(id);
    }


}
