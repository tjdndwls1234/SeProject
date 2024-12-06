package com.example.SeProject.service;

import com.example.SeProject.domain.CourseSearchCriteria;
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

    public List<CourseDto> searchCourseList(CourseSearchCriteria criteria){
        List<CourseDto> courseList = courseSearchMapper.searchCourseList(criteria);
        if (courseList.isEmpty()) return courseList;
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
        String[] s_start, s_end, c_start, c_end;
        //시간표 겹치는 과목 필터링
        if (Objects.equals(criteria.getIsScheduleConflict(), "Y")){
            List<StudentScheduleDto> studentScheduleList = studentScheduleMapper.timetableSearch(criteria.getStudentCode());
            if (!studentScheduleList.isEmpty()){
                for (int i = 0; i != studentScheduleList.size(); i++){
                    for (int j = 0; j != courseList.size(); j++){
                        if (Objects.equals(studentScheduleList.get(i).getCourseDay(), courseList.get(j).getCourseDay())){
                            s_start = studentScheduleList.get(i).getCourseStartTime().split(":");
                            s_end = studentScheduleList.get(i).getCourseEndTime().split(":");
                            c_start = courseList.get(j).getCourseStartTime().split(":");
                            c_end = courseList.get(j).getCourseEndTime().split(":");
                            if((Integer.parseInt(c_start[0]) > Integer.parseInt(s_end[0]))
                                    && (Integer.parseInt(c_end[0]) < Integer.parseInt(s_start[0]))){
                                deleteIndex.add(i);
                                break;
                            }
                        }
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
