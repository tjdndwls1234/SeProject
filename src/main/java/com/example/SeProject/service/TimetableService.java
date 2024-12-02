package com.example.SeProject.service;

import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.mapper.StudentScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    public StudentScheduleMapper studentScheduleMapper;

    @Autowired
    public TimetableService(StudentScheduleMapper studentScheduleMapper) {
        this.studentScheduleMapper = studentScheduleMapper;
    }

    public List<StudentScheduleDto> timetableSearch(String studentCode){
        return studentScheduleMapper.timetableSearch(studentCode);
    }
}
