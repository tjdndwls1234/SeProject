package com.example.SeProject.mapper;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.CourseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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