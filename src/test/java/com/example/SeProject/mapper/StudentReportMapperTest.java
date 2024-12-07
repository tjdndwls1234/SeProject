package com.example.SeProject.mapper;

import com.example.SeProject.dto.StudentReportDto;
import com.example.SeProject.dto.StudentScheduleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentReportMapperTest {
    @Autowired
    private StudentReportMapper studentReportMapper;

    @Test
    public void studentReportSearchTest() {
        // SearchCriteria 객체 생성 및 필터 조건 설정
        String studentCode = "900001";

        // CourseSearchMapper 호출하여 과목 검색
        List<StudentReportDto> courses = studentReportMapper.studentReportSearch(studentCode);


        // 결과 검증
        assertNotNull(courses);
        assertFalse(courses.isEmpty());

        // 결과 출력 (콘솔에 출력)
        courses.forEach(course -> {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Devision: "  + course.getCourseDevision());
            System.out.println("CREDIT: " + course.getCredit());
            System.out.println("COURSE REPORT: " + course.getCourseReport());
            System.out.println("====================================");
        });
    }
}
