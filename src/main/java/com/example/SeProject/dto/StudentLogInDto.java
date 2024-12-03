package com.example.SeProject.dto;

import lombok.Data;

@Data
public class StudentLogInDto {
    private String id;	//DB: ID
    private String pw;	//DB: PASSWORD
}