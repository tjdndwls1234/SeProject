package com.example.SeProject.service;

import com.example.SeProject.dto.StudentDto;
import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    //임의 학번
    public String generateStudentCode() {
        //DB에서 가장 큰 학번 조회
        String maxStudentCode = studentMapper.getMaxStudentCode();

        //초기 학번 000001
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

    //회원조회
    public List<StudentDto> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    //회원삭제
    public String deleteStudent(String id) {
        int count = studentMapper.deleteStudent(id);
        //1: 성공, 0: 실패
        if (count > 0) {
            return "Delete Success";
        }
        return "Delete Fail";
    }

}
