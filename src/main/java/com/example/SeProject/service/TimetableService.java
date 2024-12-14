package com.example.SeProject.service;

import com.example.SeProject.domain.CourseTime;
import com.example.SeProject.domain.TimetableEntry;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.mapper.CourseSearchMapper;
import com.example.SeProject.mapper.StudentScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
public class TimetableService {
    public StudentScheduleMapper studentScheduleMapper;
    public CourseSearchMapper courseSearchMapper;

    @Autowired
    public TimetableService(StudentScheduleMapper studentScheduleMapper, CourseSearchMapper courseSearchMapper) {
        this.studentScheduleMapper = studentScheduleMapper;
        this.courseSearchMapper = courseSearchMapper;
    }



    public List<StudentScheduleDto> updateTimetable(String studentCode){
        return studentScheduleMapper.getTimetable(studentCode);
    }

    public String addCourseToTimetable(TimetableEntry entry){
        List<StudentScheduleDto> timetableCourseList = studentScheduleMapper.getTimetable(entry.getStudentCode());
        List<CourseDto> courses = courseSearchMapper.searchCourse(entry.getCourseCode());
        for (StudentScheduleDto courseOnTimetable : timetableCourseList){
            for (CourseDto course : courses){
                if (isOverlapping(courseOnTimetable, course)) return "Overlapped";
            }
        }

        int result = studentScheduleMapper.addCourseToTimetable(entry);
        if (result == 1)
            return "Success";
        return "Failure";
    }

    public boolean isOverlapping(StudentScheduleDto course1, CourseDto course2){
        if (!Objects.equals(course1.getCourseDay(), course2.getCourseDay())) return false;
        CourseTime courseA = new CourseTime(course1);
        CourseTime courseB = new CourseTime(course2);

        return courseA.isOverLappingWith(courseB);
    }
}
