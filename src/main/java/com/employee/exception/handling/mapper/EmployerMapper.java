package com.employee.exception.handling.mapper;

import com.employee.exception.handling.dao.entity.Employer;
import com.employee.exception.handling.dto.request.EmployerRequestDto;
import com.employee.exception.handling.dto.response.EmployerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerMapper {
    List<EmployerResponseDto> convertAllEmployerEntityToResponseDto(List<Employer> employers);

    EmployerResponseDto convertEmployerEntityToResponseDto(Employer employer);

    Employer convertEmployerRequestDtoToEntity(EmployerRequestDto employerRequestDto);
}
