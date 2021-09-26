package com.employee.exception.handling.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeId;
    String employeeName;
    String employeeSurname;
    Double employeeSalary;
    @ManyToOne(targetEntity = Employer.class)
    @JoinColumn(name = "employer_id", referencedColumnName = "employerId")
    Employer employer;
}
