package com.example.SeProject.controller;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.service.CourseSearchService;
import com.example.SeProject.service.TimetableService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MainPage")
public class MainPageController {
    private final CourseSearchService courseSearchService;
    private final TimetableService timetableService;

    @Autowired
    public MainPageController(CourseSearchService courseSearchService, TimetableService timetableService){
        this.courseSearchService = courseSearchService;
        this.timetableService = timetableService;
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

    @RequestMapping(value = "/TimetableUpdate")
    public ResponseEntity<List<StudentScheduleDto>> TimetableSearch(HttpServletRequest request) {
        String studentCode = request.getParameter("studentCode");

        return ResponseEntity.ok().body(timetableService.timetableSearch(studentCode));
    }
}
