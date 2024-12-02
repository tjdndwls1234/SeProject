package com.example.SeProject.mapper;

import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.domain.SearchCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseSearchMapperTest {

    @Autowired
    private CourseSearchMapper courseSearchMapper;

    @Test
    public void testCourseSearch() {
        // SearchCriteria 객체 생성 및 필터 조건 설정
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCourseDepartmentName("Computer Science");  // 예시: 컴퓨터 과학 학과
        criteria.setGrade("2");  // 예시: 2학년
        criteria.setCourseDay("Monday");  // 예시: 월요일
        criteria.setCourseStartTime("09:00");  // 예시: 09:00

        // CourseSearchMapper 호출하여 과목 검색
        List<CourseDto> courses = courseSearchMapper.CourseSearch(criteria);

        // 결과 검증
        assertNotNull(courses);
        assertFalse(courses.isEmpty());

        // 결과 출력 (콘솔에 출력)
        courses.forEach(course -> {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Professor Name: " + course.getProfessorName());
            System.out.println("Course Start Time: " + course.getCourseStartTime());
            System.out.println("Course End Time: " + course.getCourseEndTime());
            System.out.println("Course Day: " + course.getCourseDay());
            System.out.println("Total Capacity: " + course.getTotalCapacity());
            System.out.println("====================================");
        });
    }
}