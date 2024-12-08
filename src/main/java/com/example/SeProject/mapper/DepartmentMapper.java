package com.example.SeProject.mapper;

import com.example.SeProject.dto.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    //학과정보 조회
    List<DepartmentDto> getAllDepartments();

    //학과이름 -> 학과코드 조회
    String getDepartmentCode(String departmentName);

}

