package com.employee.exception.handling.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponseDto {
    Long employeeId;
    String employeeName;
    String employeeSurname;
    Double employeeSalary;
    Long employerId;
}

