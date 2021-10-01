package com.employee.exception.handling.service.impl;

import com.employee.exception.handling.dao.repository.EmployeeRepository;
import com.employee.exception.handling.dao.repository.EmployerRepository;
import com.employee.exception.handling.dto.request.EmployeeRequestDto;
import com.employee.exception.handling.dto.response.EmployeeResponseDto;
import com.employee.exception.handling.mapper.EmployeeMapper;
import com.employee.exception.handling.mapper.EmployerMapper;
import com.employee.exception.handling.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    EmployerRepository employerRepository;
    EmployeeMapper employeeMapper;
    EmployerMapper employerMapper;


    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        var allEmployees = employeeRepository.findAll();
        return employeeMapper.convertAllEmployeeEntityToResponse(allEmployees);
    }

    @Override
    public EmployeeResponseDto getEmployee(Long employeeId) {
        var employee = employeeRepository.findByEmployeeId(employeeId);
        return employeeMapper.convertEmployeeEntityToResponse(employee);
    }

    @Override
    public Long saveNewEmployee(EmployeeRequestDto employeeRequestDto) {
        var employer = employerRepository.findByEmployerId(employeeRequestDto.getEmployerId());
        var requestToEntity = employeeMapper.convertEmployeeRequestDtoToEntity(employeeRequestDto, employer);
        var id = employeeRepository.save(requestToEntity);
        return id.getEmployeeId();
    }

    @Override
    public void deleteEmployee(Long employerId) {
        employeeRepository.deleteByEmployeeId(employerId);
    }
}
