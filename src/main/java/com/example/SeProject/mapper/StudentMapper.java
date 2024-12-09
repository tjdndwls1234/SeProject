package com.example.SeProject.mapper;

import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    //SignUp
    int checkDuplicateId(String id);    //아이디 중복 확인
    String getMaxStudentCode();    //임의 학번

    void insertStudent(StudentSignUpDto studentSignUpDto);    //회원가입

    //Login
    StudentSignUpDto logIn(String id, String pw);

    //Student
    List<StudentDto> getAllStudents();    //회원목록 조회
    int deleteStudent(String id);    //회원삭제(ID)

    //studentCode로 studentDepartmentCode
    String getStudentDepartmentCode(String studentCode);
}
