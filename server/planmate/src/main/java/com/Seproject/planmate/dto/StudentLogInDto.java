//SQL 결과를 매핑
package com.Seproject.planmate.dto;

import lombok.Data;

@Data
public class StudentLogInDto {
    private String id;	//DB: ID
    private String pw;	//DB: PASSWORD
}