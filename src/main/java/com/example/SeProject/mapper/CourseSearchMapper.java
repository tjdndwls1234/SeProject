package com.example.SeProject.mapper;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseSearchMapper {
    public List<CourseDto> CourseSearch(SearchCriteria criteria);
}
