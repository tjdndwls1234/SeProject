package com.example.SeProject.controller;

import com.example.SeProject.dto.PrePostCourseDto;
import com.example.SeProject.service.PrePostCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrePostCourseController {
    public PrePostCourseService prePostCourseService;

    @Autowired
    public PrePostCourseController(PrePostCourseService prePostCourseService){
        this.prePostCourseService = prePostCourseService;
    }

    @PostMapping("/CourseUpdate")
    public ResponseEntity<List<PrePostCourseDto>> getPrePostCourseList(@RequestParam String departmentName){

        return ResponseEntity.ok().body(prePostCourseService.getPrePostCourseList(departmentName));
    }
}
