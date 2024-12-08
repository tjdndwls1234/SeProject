package com.example.SeProject.service;

import com.example.SeProject.dto.PrePostCourseDto;
import com.example.SeProject.mapper.PrePostCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrePostCourseService {
    public PrePostCourseMapper prePostCourseMapper;

    @Autowired
    public PrePostCourseService(PrePostCourseMapper prePostCourseMapper){
        this.prePostCourseMapper = prePostCourseMapper;
    }

    public List<PrePostCourseDto> getPrePostCourseList(String departmentName){
        return getPrePostCourseList(departmentName);
    }
}
