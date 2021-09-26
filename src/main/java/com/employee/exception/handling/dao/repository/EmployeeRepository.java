package com.employee.exception.handling.dao.repository;

import com.employee.exception.handling.dao.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    Employee findByEmployeeId(Long employeeId);

    void deleteByEmployeeId(Long employeeId);
}
