package com.example.PlanMate.mapper;

import com.example.PlanMate.domain.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentReportMapper {

    public List<String> retakeableCourseListSearch(SearchCriteria criteria);
}
