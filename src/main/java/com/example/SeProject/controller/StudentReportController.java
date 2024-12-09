package com.example.SeProject.controller;

import com.example.SeProject.dto.StudentReportDto;
import com.example.SeProject.service.StudentReportService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping
@RestController
public class StudentReportController {
    public StudentReportService studentReportService;

    @Autowired
    public StudentReportController(StudentReportService studentReportService) {
        this.studentReportService = studentReportService;
    }

    @PostMapping("/Report/getReport")
    public ResponseEntity<List<StudentReportDto>> studentReport(HttpServletRequest request) {
        String studentCode = request.getParameter("studentCode");

        return ResponseEntity.ok().body(studentReportService.studentReportSearch(studentCode));
    }
}
