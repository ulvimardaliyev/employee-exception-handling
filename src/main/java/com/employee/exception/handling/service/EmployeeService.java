package com.employee.exception.handling.service;

import com.employee.exception.handling.dto.request.EmployeeRequestDto;
import com.employee.exception.handling.dto.response.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto getEmployee(Long employeeId);

    Long saveNewEmployee(EmployeeRequestDto employeeRequestDto);

    void deleteEmployee(Long employerId);
}
