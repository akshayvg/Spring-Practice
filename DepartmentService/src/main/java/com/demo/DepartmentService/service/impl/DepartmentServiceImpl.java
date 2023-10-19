package com.demo.DepartmentService.service.impl;
import com.demo.DepartmentService.dto.DepartmentDto;
import com.demo.DepartmentService.entity.Department;
import com.demo.DepartmentService.repository.DepartmentRepository;
import com.demo.DepartmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getId(),departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode());
        Department savedDepartment = departmentRepository.save(department);
        return new DepartmentDto(savedDepartment.getId(),savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),savedDepartment.getDepartmentCode());
    }
    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return new DepartmentDto(department.getId(),department.getDepartmentName(),department.getDepartmentDescription(),
                department.getDepartmentCode());
    }
}
