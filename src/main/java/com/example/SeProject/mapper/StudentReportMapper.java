package com.example.SeProject.mapper;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.StudentReportDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentReportMapper {
    public List<StudentReportDto> studentReportSearch(String studentCode);
    public List<String> retakeableCourseListSearch(SearchCriteria criteria);
}
