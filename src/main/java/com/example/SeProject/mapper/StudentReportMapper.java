package com.example.SeProject.mapper;

import com.example.SeProject.domain.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentReportMapper {
    public List<String> retakeableCourseListSearch(SearchCriteria criteria);
}
