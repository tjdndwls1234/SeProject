package com.example.PlanMate.mapper;

import com.example.PlanMate.domain.Course;
import com.example.PlanMate.domain.SearchCriteria;
import com.example.PlanMate.dto.CourseDto;
import com.example.PlanMate.dto.CourseSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseSearchMapper {
    public List<CourseDto> CourseSearch(SearchCriteria criteria);
}
