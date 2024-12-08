package com.example.SeProject.mapper;

import com.example.SeProject.dto.PrePostCourseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrePostCourseMapper {
    public List<PrePostCourseDto> getPrePostCourseList(String departmentName);
}
