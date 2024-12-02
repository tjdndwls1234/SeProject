package com.example.SeProject;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.mapper.CourseSearchMapper;
import com.example.SeProject.service.CourseSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CourseSearchServiceTest {

    @Mock
    private CourseSearchMapper courseSearchMapper; // Mapper를 Mock

    @InjectMocks
    private CourseSearchService courseSearchService; // Service 클래스에 Mapper 주입

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }

    @Test
    public void testCourseSearch() {
        // 테스트할 SearchCriteria 객체 생성
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCourseDepartmentName("Computer Science");

        // 예상되는 결과 값 (CourseDto 객체)
        List<CourseDto> expectedCourses = Arrays.asList(
                // 첫 번째 과목
                new CourseDto("CS101", "Introduction to Computer Science", "Computer Science", 'A', 3, "Lecture", "Dr. John Doe", "Mon", "50", "09:00", "11:00", "Room 101"),

                // 두 번째 과목
                new CourseDto("CS102", "Data Structures", "Computer Science", 'B', 3, "Lecture", "Prof. Jane Smith", "Wed", "50", "13:00", "15:00", "Room 102"),

                // 세 번째 과목
                new CourseDto("MATH201", "Calculus I", "Mathematics", 'A', 4, "Lecture", "Dr. Albert Einstein", "Tue", "60", "10:00", "12:00", "Room 203"),

                // 네 번째 과목
                new CourseDto("MATH202", "Linear Algebra", "Mathematics", 'B', 3, "Lecture", "Prof. Marie Curie", "Thu", "55", "14:00", "16:00", "Room 204"),

                // 다섯 번째 과목
                new CourseDto("PHY101", "Physics I", "Physics", 'A', 4, "Lecture", "Dr. Isaac Newton", "Mon", "50", "08:00", "10:00", "Room 301"),

                // 여섯 번째 과목
                new CourseDto("BIO101", "Introduction to Biology", "Biology", 'C', 3, "Lecture", "Dr. Charles Darwin", "Fri", "45", "11:00", "13:00", "Room 102"),

                // 일곱 번째 과목
                new CourseDto("CHEM101", "General Chemistry", "Chemistry", 'B', 3, "Lecture", "Prof. Marie Curie", "Mon", "50", "10:00", "12:00", "Room 201"),

                // 여덟 번째 과목
                new CourseDto("ENG101", "English Literature", "Literature", 'A', 2, "Lecture", "Prof. William Shakespeare", "Tue", "40", "14:00", "16:00", "Room 107"),

                // 아홉 번째 과목
                new CourseDto("CS201", "Operating Systems", "Computer Science", 'A', 3, "Lecture", "Dr. Linus Torvalds", "Thu", "45", "13:00", "15:00", "Room 105"),

                // 열 번째 과목
                new CourseDto("CS202", "Algorithms", "Computer Science", 'B', 3, "Lecture", "Prof. Donald Knuth", "Wed", "50", "10:00", "12:00", "Room 106"),

                // 열한 번째 과목
                new CourseDto("STAT101", "Statistics", "Statistics", 'A', 3, "Lecture", "Dr. John Tukey", "Mon", "45", "09:00", "11:00", "Room 110"),

                // 열두 번째 과목
                new CourseDto("ECO101", "Economics 101", "Economics", 'C', 3, "Lecture", "Prof. Adam Smith", "Fri", "50", "10:00", "12:00", "Room 203"),

                // 열세 번째 과목
                new CourseDto("PSY101", "Introduction to Psychology", "Psychology", 'B', 3, "Lecture", "Dr. Sigmund Freud", "Thu", "45", "15:00", "17:00", "Room 201"),

                // 열네 번째 과목
                new CourseDto("ART101", "Art History", "Art", 'A', 2, "Lecture", "Prof. Leonardo da Vinci", "Wed", "30", "14:00", "16:00", "Room 301"),

                // 열다섯 번째 과목
                new CourseDto("PHIL101", "Philosophy", "Philosophy", 'A', 2, "Lecture", "Prof. Socrates", "Tue", "35", "11:00", "13:00", "Room 104")
        );

        // Mapper의 메서드를 Mock하여 예상되는 결과 반환하도록 설정
        when(courseSearchMapper.CourseSearch(criteria)).thenReturn(expectedCourses);

        // Service 메서드 호출
        List<CourseDto> courses = courseSearchService.CourseSearch(criteria);

        // 결과 확인
        assertNotNull(courses);
        assertEquals(2, courses.size());
        assertEquals("CS101", courses.get(0).getCourseCode());
        assertEquals("Introduction to Computer Science", courses.get(0).getCourseName());
        assertEquals("Computer Science", courses.get(0).getDepartmentName());
        assertEquals('A', courses.get(0).getGrade());
        assertEquals(3, courses.get(0).getCredit());
        assertEquals("Lecture", courses.get(0).getCourseDevision());
        assertEquals("Dr. John Doe", courses.get(0).getProfessorName());
        assertEquals("Mon", courses.get(0).getCourseDay());
        assertEquals("50", courses.get(0).getTotalCapacity());
        assertEquals("09:00", courses.get(0).getCourseStartTime());
        assertEquals("11:00", courses.get(0).getCourseEndTime());
        assertEquals("Room 101", courses.get(0).getClassroom());

        // Mock된 메서드가 실제로 호출되었는지 확인
        verify(courseSearchMapper, times(1)).CourseSearch(criteria);
    }

}