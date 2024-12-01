//Mybatis에서 작성한 SQL 쿼리를 호출하는 인터페이스
package com.Seproject.planmate.mapper;

import com.Seproject.planmate.dto.StudentSignUpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    //아이디 중복 확인
    int checkDuplicateId(String id);
    //임의 학번
    String getMaxStudentCode();
    //회원가입
    void insertStudent(StudentSignUpDto studentSignUpDto);
    //로그인
    StudentSignUpDto logIn(String id, String pw);
}
