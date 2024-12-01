package com.example.SeProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseSearchDto {
    private String studentCode;
    private String courseDepartmentName;
    private String studentDepartmentName;
    private String gradeSearch;
    private String isCourseEngineeringCertified;
    private String isCourseProhibit;
    private String isRetakeableCourse;
    private String isScheduleConflict;

}
