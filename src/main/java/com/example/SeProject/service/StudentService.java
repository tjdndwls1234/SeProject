package com.example.SeProject.service;


import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    //임의 학번
    public String generateStudentCode() {
        //DB에서 가장 큰 학번 조회
        String maxStudentCode = studentMapper.getMaxStudentCode();

        //초기 학번 001
        if (maxStudentCode == null) {
            return "000001";
        }

        int nextStudentCode = Integer.parseInt(maxStudentCode) + 1;

        return String.format("%06d", nextStudentCode);
    }

    //회원가입 처리
    public String signUp(StudentSignUpDto studentSignUpDto) {
        //아이디 중복O->1, 중복X->0 반환
        int count = studentMapper.checkDuplicateId(studentSignUpDto.getId());
        //중복O
        if (count > 0) {
            return "중복되는 아이디입니다.";
        }
        //중복X
        //임의학번지정
        String studentCode = generateStudentCode();
        studentSignUpDto.setStudentCode(studentCode);

        studentMapper.insertStudent(studentSignUpDto);
        return "Sign Up Success";
    }

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

}
