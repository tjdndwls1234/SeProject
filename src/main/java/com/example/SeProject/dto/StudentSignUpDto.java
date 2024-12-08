package com.example.SeProject.dto;

import lombok.Data;

@Data
public class StudentSignUpDto {
    private String studentCode;	//DB: STUDENT_CODE
    private String studentName;	//DB: STUDENT_NAME
    private String departmentCode;	//DB: DEPARTMENT_CODE(Service에서 처리)
    private String departmentName;	//DB: DEPARTMENT_NAME
    private String id;	//DB: ID
    private String pw;	//DB: PASSWORD
}