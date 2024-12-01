package com.example.planmate.mapper;

import com.example.planmate.domain.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentReportMapper {

    public List<String> retakeableCourseListSearch(SearchCriteria criteria);
}
