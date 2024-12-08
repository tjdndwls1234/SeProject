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
