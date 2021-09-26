package com.employee.exception.handling.service;

import com.employee.exception.handling.dto.request.EmployerRequestDto;
import com.employee.exception.handling.dto.response.EmployerResponseDto;

import java.util.List;

public interface EmployerService {
    List<EmployerResponseDto> getAllEmployers();

    EmployerResponseDto getEmployerResponse(Long employerId);

    Long saveNewEmployer(EmployerRequestDto employerRequestDto);

    void deleteEmployer(Long employerId);
}
