package com.example.SeProject.service;

import com.example.SeProject.domain.SearchCriteria;
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
    public CourseSearchService(CourseSearchMapper courseSearchMapper, StudentReportMapper studentReportMapper){
        this.courseSearchMapper = courseSearchMapper;
        this.studentReportMapper = studentReportMapper;
    }

    public List<CourseDto> CourseSearch(SearchCriteria criteria){
        List<CourseDto> courseList = courseSearchMapper.CourseSearch(criteria);
        ArrayList<Integer> deleteIndex = new ArrayList<>();
        //재수강 가능 과목 필터링
        if (Objects.equals(criteria.getIsRetakeableCourse(), "Y")){
            List<String> retakeableCourseList = this.studentReportMapper.retakeableCourseListSearch(criteria);
            if (!retakeableCourseList.isEmpty()) {
                for (int i = 0; i != retakeableCourseList.size(); i++) {
                    for (int j = 0; j != courseList.size(); j++) {
                        if (Objects.equals(retakeableCourseList.get(i), courseList.get(i).getCourseCode())) {
                            deleteIndex.add(i);
                            break;
                        }
                    }
                }
                for (int i = deleteIndex.size(); i != 0 ; i--){
                    courseList.remove(deleteIndex.get(i - 1).intValue());
                }
                deleteIndex.clear();
            }
        }
        //시간표 겹치는 과목 필터링
        if (Objects.equals(criteria.getIsScheduleConflict(), "Y")){
            List<StudentScheduleDto> studentScheduleList = studentScheduleMapper.timetableSearch(criteria.getStudentCode());
            if (!studentScheduleList.isEmpty()){
                for (int i = 0; i != studentScheduleList.size(); i++){
                    for (int j = 0; j != courseList.size(); j++){
                        if (studentScheduleList.get(i).)
                    }
                }
            }
            for (int i = deleteIndex.size(); i != 0 ; i--) {
                courseList.remove(deleteIndex.get(i - 1).intValue());
            }
            deleteIndex.clear();
        }
        return courseList;
    }
}
