package com.example.SeProject.mapper;

import com.example.SeProject.domain.TimetableEntry;
import com.example.SeProject.dto.StudentScheduleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentScheduleMapper {
    public List<StudentScheduleDto> getTimetable(String studentCode);
    public int addCourseToTimetable(TimetableEntry entry);
}
