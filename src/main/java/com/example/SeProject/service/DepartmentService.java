package com.example.SeProject.service;

import com.example.SeProject.dto.DepartmentDto;
import com.example.SeProject.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    // 학부 정보 조회
    public List<DepartmentDto> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }
}
