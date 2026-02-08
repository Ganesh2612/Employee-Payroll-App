package org.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.example.model.EmployeePayroll;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Integer> {
}

