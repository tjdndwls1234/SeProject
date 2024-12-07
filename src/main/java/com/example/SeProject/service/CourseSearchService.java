package com.example.SeProject.service;

import com.example.SeProject.domain.CourseSearchCriteria;
import com.example.SeProject.domain.CourseTime;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.mapper.CourseSearchMapper;
import com.example.SeProject.mapper.StudentMapper;
import com.example.SeProject.mapper.StudentReportMapper;
import com.example.SeProject.mapper.StudentScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseSearchService {
    public CourseSearchMapper courseSearchMapper;
    public StudentReportMapper studentReportMapper;
    public StudentScheduleMapper studentScheduleMapper;
    public StudentMapper studentMapper;

    @Autowired
    public CourseSearchService(CourseSearchMapper courseSearchMapper, StudentReportMapper studentReportMapper,
                               StudentScheduleMapper studentScheduleMapper, StudentMapper studentMapper){
        this.studentReportMapper = studentReportMapper;
        this.courseSearchMapper = courseSearchMapper;
        this.studentScheduleMapper = studentScheduleMapper;
        this.studentMapper = studentMapper;
    }

    public List<CourseDto> searchCourseList(CourseSearchCriteria criteria){
        String studentCode = criteria.getStudentCode();
        criteria.setStudentDepartmentCode(studentMapper.getStudentDepartmentCode(studentCode));
        List<CourseDto> courseList = courseSearchMapper.searchCourseList(criteria);

        if (courseList.isEmpty()) return courseList;

        //재수강 가능 과목 필터링
        if (Objects.equals(criteria.getIsRetakeableCourse(), "Y")) {
            List<String> retakeableCourseList = this.studentReportMapper.retakeableCourseListSearch(criteria);

            if (!retakeableCourseList.isEmpty()) {

                courseList.removeIf(course -> retakeableCourseList.contains(course.getCourseCode()));
            }
        }

        //시간표 겹치는 과목 필터링
        if (Objects.equals(criteria.getIsScheduleConflict(), "Y")){
            List<StudentScheduleDto> courseListOnTimetable = studentScheduleMapper.getTimetable(criteria.getStudentCode());
            courseList.removeIf(course -> {
                for (StudentScheduleDto courseOnTimetable : courseListOnTimetable) {
                    if (isOverlapping(courseOnTimetable, course)) {
                        return true;
                    }
                }
                return false;
            });
        }
        return courseList;
    }

    public boolean isOverlapping(StudentScheduleDto course1, CourseDto course2){
        if (!Objects.equals(course1.getCourseDay(), course2.getCourseDay())) return false;
        CourseTime courseA = new CourseTime(course1);
        CourseTime courseB = new CourseTime(course2);

        return courseA.isOverLappingWith(courseB);
    }
}
