package com.demo.EmployeeService.service.impl;
import com.demo.EmployeeService.Dto.APIResponseDto;
import com.demo.EmployeeService.Dto.DepartmentDto;
import com.demo.EmployeeService.Dto.EmployeeDto;
import com.demo.EmployeeService.entity.Employee;
import com.demo.EmployeeService.repository.EmployeeRepository;
import com.demo.EmployeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getFirstName(),
                employeeDto.getLastName(),employeeDto.getDepartmentCode());
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeDto(savedEmployee.getId(),savedEmployee.getFirstName(),
                savedEmployee.getLastName(),savedEmployee.getEmail(),savedEmployee.getDepartmentCode());
    }
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        ResponseEntity<DepartmentDto> departmentDtoResponseEntity =  restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),employee.getFirstName(),
                employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
