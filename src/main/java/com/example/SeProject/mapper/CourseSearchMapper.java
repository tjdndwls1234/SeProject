package com.example.SeProject.mapper;

import com.example.SeProject.domain.CourseSearchCriteria;
import com.example.SeProject.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseSearchMapper {
    public List<CourseDto> searchCourseList(CourseSearchCriteria criteria);
}
