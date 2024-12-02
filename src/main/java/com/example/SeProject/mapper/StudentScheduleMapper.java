package com.example.SeProject.mapper;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.StudentScheduleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentScheduleMapper {
    public List<StudentScheduleDto> studentScheduleListSearch(SearchCriteria criteria);
    public List<StudentScheduleDto> timetableSearch(String studentCode);
}
