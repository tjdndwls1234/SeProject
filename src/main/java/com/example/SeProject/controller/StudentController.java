package com.example.SeProject.controller;

import com.example.SeProject.dto.StudentDto;
import com.example.SeProject.dto.StudentSignUpDto;
import com.example.SeProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    //회원조회
    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    //회원삭제
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String id) {

        String result = studentService.deleteStudent(id);

        if ("Delete Success".equals(result)) {
            return ResponseEntity.ok("Delete Success");
        }
        return ResponseEntity.status(404).body("Delete Fail");
    }
}
