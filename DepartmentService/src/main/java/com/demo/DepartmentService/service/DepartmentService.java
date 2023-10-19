package com.demo.DepartmentService.service;
import com.demo.DepartmentService.dto.DepartmentDto;
public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
