package com.employee.exception.handling.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestDto {
    String employeeName;
    String employeeSurname;
    Double employeeSalary;
    Long employerId;
}
