package com.example.SeProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentScheduleDto {
    private String courseCode;
    private String courseName;
    private String courseStartTime;
    private String courseEndTime;
    private String courseDay;
    private String classroom;
    private String professorName;
}
