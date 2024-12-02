package com.example.SeProject.controller;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.service.CourseSearchService;
import com.example.SeProject.service.TimetableService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/CourseSearch")
    public ResponseEntity<List<CourseDto>> CourseSearch(@RequestParam String studentCode,
                                                        @RequestParam(required = false) String courseDepartmentName,
                                                        @RequestParam(required = false) String grade,
                                                        @RequestParam(required = false) String courseStartTime,
                                                        @RequestParam(required = false) String courseDay,
                                                        @RequestParam(required = false) String studentDepartmentName,
                                                        @RequestParam(required = false) String isCourseEngineeringCertified,
                                                        @RequestParam(required = false) String isCourseProhibit,
                                                        @RequestParam(required = false) String isRetakeableCourse,
                                                        @RequestParam(required = false) String isScheduleConflict) {

        // SearchCriteria 객체 초기화
        SearchCriteria criteria = new SearchCriteria();

        // 필수 파라미터들 설정
        criteria.setStudentCode(studentCode);
        criteria.setCourseDepartmentName(courseDepartmentName);
        criteria.setGrade(grade);
        criteria.setCourseStartTime(courseStartTime);
        criteria.setCourseDay(courseDay);
        criteria.setStudentDepartmentName(studentDepartmentName);

        // Y/N 값 처리: 선택되었으면 Y, 선택되지 않았으면 N
        criteria.setIsCourseEngineeringCertified(isCourseEngineeringCertified != null ? isCourseEngineeringCertified : "N");
        criteria.setIsCourseProhibit(isCourseProhibit != null ? isCourseProhibit : "N");
        criteria.setIsRetakeableCourse(isRetakeableCourse != null ? isRetakeableCourse : "N");
        criteria.setIsScheduleConflict(isScheduleConflict != null ? isScheduleConflict : "N");

        // 서비스 호출 및 결과 반환
        return ResponseEntity.ok().body(courseSearchService.CourseSearch(criteria));
    }
    @RequestMapping(value = "/TimetableUpdate")
    public ResponseEntity<List<StudentScheduleDto>> TimetableSearch(HttpServletRequest request) {
        String studentCode = request.getParameter("studentCode");

        return ResponseEntity.ok().body(timetableService.timetableSearch(studentCode));
    }
}
