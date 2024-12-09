package com.example.SeProject.controller;

import com.example.SeProject.domain.CourseSearchCriteria;
import com.example.SeProject.domain.TimetableEntry;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.service.CourseSearchService;
import com.example.SeProject.service.TimetableService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainPageController {
    private final CourseSearchService courseSearchService;
    private final TimetableService timetableService;

    @Autowired
    public MainPageController(CourseSearchService courseSearchService, TimetableService timetableService){
        this.courseSearchService = courseSearchService;
        this.timetableService = timetableService;
    }

    //Search Course List
    @PostMapping("/MainPage/CourseSearch")
    public ResponseEntity<List<CourseDto>> searchCourseList(@RequestBody CourseSearchCriteria criteria, HttpServletRequest request) {
        //Call Session and Set StudentCode in criteria
        HttpSession session = request.getSession(false);
        criteria.setStudentCode((String)session.getAttribute("StudentCode"));
        System.out.println(criteria.isScheduleConflict());
        return ResponseEntity.ok().body(courseSearchService.searchCourseList(criteria));
    }

    //Update Timetable
    @PostMapping(value = "/TimetableUpdate")
    public ResponseEntity<List<StudentScheduleDto>> updateTimetable(HttpServletRequest request) {
        String studentCode = request.getParameter("studentCode");

        return ResponseEntity.ok().body(timetableService.updateTimetable(studentCode));
    }

    @PostMapping(value = "/CourseAdd")
    public ResponseEntity<String> addCourseToTimetable(@RequestBody TimetableEntry entry, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        entry.setStudentCode((String)session.getAttribute("StudentCode"));
        System.out.println(session.getAttribute("StudentCode"));
        return ResponseEntity.ok().body(timetableService.addCourseToTimetable(entry));
    }
}
