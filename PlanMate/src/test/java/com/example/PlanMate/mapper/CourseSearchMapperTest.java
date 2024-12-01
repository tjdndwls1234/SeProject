package com.example.PlanMate.mapper;

import com.example.PlanMate.domain.SearchCriteria;
import com.example.PlanMate.dto.CourseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseSearchMapperTest {

    @Autowired
    private CourseSearchMapper mapper;


    @Test
    public void CourseSearchTest(){
        SearchCriteria criteria = new SearchCriteria();

        System.out.println("cri : " + criteria);
        List<CourseDto> list = mapper.CourseSearch(criteria);
        System.out.println("list :" + list);
    }
}