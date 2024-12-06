package com.example.SeProject.service;

import com.example.SeProject.domain.CourseSearchCriteria;
import com.example.SeProject.domain.CourseTime;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import com.example.SeProject.mapper.CourseSearchMapper;
import com.example.SeProject.mapper.StudentReportMapper;
import com.example.SeProject.mapper.StudentScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseSearchService {
    public CourseSearchMapper courseSearchMapper;
    public StudentReportMapper studentReportMapper;
    public StudentScheduleMapper studentScheduleMapper;

    @Autowired
    public CourseSearchService(CourseSearchMapper courseSearchMapper, StudentReportMapper studentReportMapper,
                               StudentScheduleMapper studentScheduleMapper){
        this.studentReportMapper = studentReportMapper;
        this.courseSearchMapper = courseSearchMapper;
        this.studentScheduleMapper = studentScheduleMapper;
    }

    public List<CourseDto> searchCourseList(CourseSearchCriteria criteria){
        List<CourseDto> courseList = courseSearchMapper.searchCourseList(criteria);
        if (courseList.isEmpty()) return courseList;
        ArrayList<String> deleteCourseCode = new ArrayList<>();
        ArrayList<Integer> deleteIndex = new ArrayList<>();
        //재수강 가능 과목 필터링
        if (Objects.equals(criteria.getIsRetakeableCourse(), "Y")) {
            List<String> retakeableCourseList = this.studentReportMapper.retakeableCourseListSearch(criteria);

            if (!retakeableCourseList.isEmpty()) {
                // 재수강 가능한 과목을 필터링하여 제거
                courseList.removeIf(course -> retakeableCourseList.contains(course.getCourseCode()));
            }
        }

        //시간표 겹치는 과목 필터링
        if (Objects.equals(criteria.getIsScheduleConflict(), "Y")){
            List<StudentScheduleDto> courseListOnTimetable = studentScheduleMapper.getTimetable(criteria.getStudentCode());
            courseList.removeIf(course -> {
                for (StudentScheduleDto courseOnTimetable : courseListOnTimetable) {
                    if (isOverlapping(courseOnTimetable, course)) {
                        return true; // 겹치는 과목은 제거
                    }
                }
                return false; // 겹치지 않으면 남김
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
