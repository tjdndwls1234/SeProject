package com.example.SeProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private String courseCode;
    private String courseName;
    private String departmentName;
    private char grade;
    private int credit;
    private String courseDevision;
    private String professorName;
    private String courseDay;
    private String totalCapacity;
    private String courseStartTime;
    private String courseEndTime;
    private String classroom;

    public CourseDto() {
    }

    public CourseDto(String courseCode, String courseName, String departmentName, char grade, int credit,
                     String courseDevision, String professorName, String courseDay, String totalCapacity,
                     String courseStartTime, String courseEndTime, String classroom) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.departmentName = departmentName;
        this.grade = grade;
        this.credit = credit;
        this.courseDevision = courseDevision;
        this.professorName = professorName;
        this.courseDay = courseDay;
        this.totalCapacity = totalCapacity;
        this.courseStartTime = courseStartTime;
        this.courseEndTime = courseEndTime;
        this.classroom = classroom;
    }
}
