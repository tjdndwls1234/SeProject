package com.example.SeProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentScheduleDto {
    private String courseCode;
    private String courseStartTime;
    private String courseEndTime;
    private String courseDay;
}
