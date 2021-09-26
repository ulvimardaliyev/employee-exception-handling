package com.employee.exception.handling.mapper;

import com.employee.exception.handling.dao.entity.Employee;
import com.employee.exception.handling.dao.entity.Employer;
import com.employee.exception.handling.dto.request.EmployeeRequestDto;
import com.employee.exception.handling.dto.response.EmployeeResponseDto;
import com.employee.exception.handling.service.impl.EmployerServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {EmployerMapper.class, EmployerServiceImpl.class})
public interface EmployeeMapper {
    List<EmployeeResponseDto> convertAllEmployeeEntityToResponse(List<Employee> allEmployees);

    @Mapping(target = "employerId", source = "employer", qualifiedByName = "getEmployerId")
    EmployeeResponseDto convertEmployeeEntityToResponse(Employee employee);

    @Mapping(target = "employer",
            source = "employerId", qualifiedByName = "getEmployer")
    Employee convertEmployeeRequestDtoToEntity(EmployeeRequestDto employeeRequestDto);
    /*@Mapping(target = "employer",
            expression = "java(employerServiceImpl.getEmployer(employeeRequestDto.getEmployerId()))")
    Employee convertEmployeeRequestDtoToEntity(EmployeeRequestDto employeeRequestDto);*/

    @Named("getEmployerId")
    static Long getEmployerId(Employer employer) {
        return employer.getEmployerId();
    }

}
