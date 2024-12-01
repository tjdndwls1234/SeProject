package com.example.PlanMate.controller;

import com.example.PlanMate.domain.SearchCriteria;
import com.example.PlanMate.dto.CourseDto;
import com.example.PlanMate.service.CourseSearchService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MainPage")
public class MainPageController {
    private final CourseSearchService courseSearchService;

    @Autowired
    public MainPageController(CourseSearchService courseSearchService){
        this.courseSearchService = courseSearchService;
    }

    @RequestMapping(value = "/CourseSearch")
    public ResponseEntity<List<CourseDto>> CourseSearch(HttpServletRequest request) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setStudentCode(request.getParameter("studentCode"));
        criteria.setCourseDepartmentName(request.getParameter("courseDepartmentName"));
        criteria.setStudentDepartmentName(request.getParameter("studentDepartmentName"));
        criteria.setGrade(request.getParameter("grade"));;
        criteria.setCourseStartTime(request.getParameter("courseStartTime"));
        criteria.setCourseDay(request.getParameter("courseDay"));
        criteria.setIsCourseEngineeringCertified(request.getParameter("isCourseEngineeringCertified"));
        criteria.setIsCourseProhibit(request.getParameter("isCourseProhibit"));
        criteria.setIsRetakeableCourse(request.getParameter("isRetakeableCourse"));
        criteria.setIsScheduleConflict(request.getParameter("isScheduleConflict"));

        return ResponseEntity.ok().body(courseSearchService.CourseSearch(criteria));
    }
}
