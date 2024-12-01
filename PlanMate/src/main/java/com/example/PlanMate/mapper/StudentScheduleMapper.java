package com.example.PlanMate.mapper;

import com.example.PlanMate.domain.CourseSchedule;
import com.example.PlanMate.domain.SearchCriteria;
import com.example.PlanMate.dto.StudentScheduleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentScheduleMapper {
    public List<StudentScheduleDto> studentScheduleListSearch(SearchCriteria criteria);
}
