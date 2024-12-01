package com.example.planmate.mapper;

import com.example.planmate.domain.SearchCriteria;
import com.example.planmate.dto.StudentScheduleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentScheduleMapper {
    public List<StudentScheduleDto> studentScheduleListSearch(SearchCriteria criteria);
}
