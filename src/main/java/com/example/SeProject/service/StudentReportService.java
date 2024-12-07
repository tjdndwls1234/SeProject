package com.example.SeProject.service;

import com.example.SeProject.dto.StudentReportDto;
import com.example.SeProject.mapper.StudentReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentReportService {
    public StudentReportMapper studentReportMapper;

    @Autowired
    public StudentReportService(StudentReportMapper studentReportMapper) {
        this.studentReportMapper = studentReportMapper;
    }

    public List<StudentReportDto> studentReportSearch(String studentCode){
        return studentReportMapper.studentReportSearch(studentCode);
    }
}
