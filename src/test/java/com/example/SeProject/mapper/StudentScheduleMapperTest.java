package com.example.SeProject.mapper;

import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.domain.CourseSearchCriteria;
import com.example.SeProject.dto.StudentScheduleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentScheduleMapperTest {

    @Autowired
    private StudentScheduleMapper studentScheduleMapper;

    @Test
    public void testGetTimetable() {
        // SearchCriteria 객체 생성 및 필터 조건 설정
        String studentCode = "900001";

        // CourseSearchMapper 호출하여 과목 검색
        List<StudentScheduleDto> courses = studentScheduleMapper.getTimetable(studentCode);

        // 결과 검증
        assertNotNull(courses);
        assertFalse(courses.isEmpty());

        // 결과 출력 (콘솔에 출력)
        courses.forEach(course -> {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());

            System.out.println("Course Start Time: " + course.getCourseStartTime());
            System.out.println("Course End Time: " + course.getCourseEndTime());
            System.out.println("Course Day: " + course.getCourseDay());
            System.out.println("CLASSROOM: " + course.getClassroom());
            System.out.println("Professor Name: " + course.getProfessorName());
            System.out.println("====================================");
        });
    }
}
