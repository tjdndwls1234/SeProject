package com.example.SeProject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseSearchCriteria {
    //설정안하면 꼭 null로 보내줄 것
    private String studentCode; // session을 통해 입력받음
    private String studentDepartmentCode; // stduentCode로 service에서 입력받음
    private String courseKeyword; // Front에서 입력받음
    private String courseDepartmentName; // Front에서 입력받음
    private String courseDevision; // Front에서 입력받음
    private String grade; // Front에서 입력받음
    private String courseStartTime; // Front에서 입력받음
    private String courseDay; // Front에서 입력받음
    @JsonProperty("isCourseEngineeringCertified")
    private boolean isCourseEngineeringCertified; // Front에서 입력받음
    @JsonProperty("isCourseProhibit")
    private boolean isCourseProhibit; // Front에서 입력받음
    @JsonProperty("isRetakeableCourse")
    private boolean isRetakeableCourse; // Front에서 입력받음
    @JsonProperty("isScheduleConflict")
    private boolean isScheduleConflict; // Front에서 입력받음
}
