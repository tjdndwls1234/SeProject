package com.example.SeProject.mapper;

import com.example.SeProject.domain.SearchCriteria;
import com.example.SeProject.dto.CourseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
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