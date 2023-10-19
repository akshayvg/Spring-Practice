package com.demo.EmployeeService.service;

import com.demo.EmployeeService.Dto.APIResponseDto;
import com.demo.EmployeeService.Dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
