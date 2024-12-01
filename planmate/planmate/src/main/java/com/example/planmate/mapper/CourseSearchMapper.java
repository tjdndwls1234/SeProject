package com.example.planmate.mapper;

import com.example.planmate.domain.SearchCriteria;
import com.example.planmate.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseSearchMapper {
    public List<CourseDto> CourseSearch(SearchCriteria criteria);
}
