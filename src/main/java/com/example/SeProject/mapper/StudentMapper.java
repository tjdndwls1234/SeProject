package com.example.SeProject.mapper;

import com.example.SeProject.dto.StudentSignUpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    //아이디 중복 확인
    int checkDuplicateId(String id);
    //임의 학번
    String getMaxStudentCode();
    //회원가입
    void insertStudent(StudentSignUpDto studentSignUpDto);
    //로그인
    StudentSignUpDto logIn(String id, String pw);
}
