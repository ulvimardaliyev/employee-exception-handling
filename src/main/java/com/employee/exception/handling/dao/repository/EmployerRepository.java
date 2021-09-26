package com.employee.exception.handling.dao.repository;

import com.employee.exception.handling.dao.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    @Override
    List<Employer> findAll();

    Employer findByEmployerId(Long employerId);

    void deleteByEmployerId(Long employerId);
}
