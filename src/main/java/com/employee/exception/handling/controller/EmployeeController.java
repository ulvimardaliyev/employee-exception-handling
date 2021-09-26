package com.employee.exception.handling.controller;

import com.employee.exception.handling.dto.request.EmployeeRequestDto;
import com.employee.exception.handling.dto.response.EmployeeResponseDto;
import com.employee.exception.handling.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeResponseDto getEmployee(@PathVariable Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public Long saveNewEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.saveNewEmployee(employeeRequestDto);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
