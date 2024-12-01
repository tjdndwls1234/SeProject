package com.example.planmate.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteria {
    //private String courseDepartmentName;
    private String studentCode;
    private String courseDepartmentName;
    private String studentDepartmentName;
    private String grade;
    private String courseStartTime;
    private String courseDay;
    private String isCourseEngineeringCertified;
    private String isCourseProhibit;
    private String isRetakeableCourse;
    private String isScheduleConflict;
}
