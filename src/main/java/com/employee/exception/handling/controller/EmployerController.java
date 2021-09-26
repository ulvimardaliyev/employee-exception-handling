package com.employee.exception.handling.controller;

import com.employee.exception.handling.dto.request.EmployerRequestDto;
import com.employee.exception.handling.dto.response.EmployerResponseDto;
import com.employee.exception.handling.service.EmployerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class EmployerController {

    EmployerService employerService;

    @GetMapping("/employers")
    public List<EmployerResponseDto> getAllEmployer() {
        return employerService.getAllEmployers();
    }

    @GetMapping("/employers/{employerId}")
    public EmployerResponseDto getEmployer(@PathVariable Long employerId) {
        return employerService.getEmployerResponse(employerId);
    }

    @PostMapping("/employers")
    public Long saveNewEmployer(@RequestBody EmployerRequestDto employerRequestDto) {
        return employerService.saveNewEmployer(employerRequestDto);
    }

    @DeleteMapping("/employers/{employerId}")
    public void deleteEmployer(@PathVariable Long employerId) {
        employerService.deleteEmployer(employerId);
    }
}
