package com.example.SeProject.domain;

import com.example.SeProject.dto.CourseDto;
import com.example.SeProject.dto.StudentScheduleDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class CourseTime {
    private LocalTime startTime;
    private LocalTime endTime;
    private String courseCode;

    public CourseTime(CourseDto courseDto) {
        this.startTime = LocalTime.parse(courseDto.getCourseStartTime());
        this.endTime = LocalTime.parse(courseDto.getCourseStartTime());
        this.courseCode = courseDto.getCourseCode();
    }

    public CourseTime(StudentScheduleDto studentScheduleDto) {
        this.startTime = LocalTime.parse(studentScheduleDto.getCourseStartTime());
        this.endTime = LocalTime.parse(studentScheduleDto.getCourseStartTime());
        this.courseCode = studentScheduleDto.getCourseCode();
    }

    public boolean isOverLappingWith(CourseTime other) {

        if (this.startTime.equals(other.startTime) && this.endTime.equals(other.endTime)) {
            return true;
        }

        if (this.endTime.equals(other.startTime) || this.startTime.equals(other.endTime)) {
            return false;
        }
        return this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime);
    }

}
