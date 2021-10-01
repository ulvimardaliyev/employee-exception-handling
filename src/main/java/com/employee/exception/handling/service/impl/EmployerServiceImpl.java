package com.employee.exception.handling.service.impl;

import com.employee.exception.handling.dao.repository.EmployerRepository;
import com.employee.exception.handling.dto.request.EmployerRequestDto;
import com.employee.exception.handling.dto.response.EmployerResponseDto;
import com.employee.exception.handling.mapper.EmployeeMapper;
import com.employee.exception.handling.mapper.EmployerMapper;
import com.employee.exception.handling.service.EmployerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class EmployerServiceImpl implements EmployerService {
    EmployerRepository employerRepository;
    EmployeeMapper employeeMapper;
    EmployerMapper employerMapper;

    @Override
    public List<EmployerResponseDto> getAllEmployers() {
        var allEmployers = employerRepository.findAll();
        return employerMapper.convertAllEmployerEntityToResponseDto(allEmployers);
    }

    @Override
    public EmployerResponseDto getEmployerResponse(Long employerId) {
        var employer = employerRepository.findByEmployerId(employerId);
        return employerMapper.convertEmployerEntityToResponseDto(employer);
    }

    @Override
    public Long saveNewEmployer(EmployerRequestDto employerRequestDto) {
        var newEmployer = employerMapper.convertEmployerRequestDtoToEntity(employerRequestDto);
        var savedEmployer = employerRepository.save(newEmployer);
        return savedEmployer.getEmployerId();
    }

    @Override
    public void deleteEmployer(Long employerId) {
        employerRepository.deleteByEmployerId(employerId);
    }
}
