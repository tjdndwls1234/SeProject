package com.example.SeProject.dto;

import lombok.Data;

@Data
public class StudentSignUpDto {
    private String studentCode;	//DB: STUDENT_CODE
    private String studentName;	//DB: STUDENT_NAME
    private String departmentCode;	//DB: DEPARTMENT_CODE
    private String id;	//DB: ID
    private String pw;	//DB: PASSWORD
}