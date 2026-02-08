package org.example.service;

import java.util.List;

import org.example.dto.EmployeePayrollDTO;
import org.example.model.EmployeePayroll;

public interface EmployeePayrollService {

    List<EmployeePayroll> getEmployeePayroll();

    EmployeePayroll getEmployeePayrollById(int empId);

    EmployeePayroll createEmployeePayroll(EmployeePayrollDTO empPayrollDTO);

    EmployeePayroll updateEmployeePayroll(int empId, EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}

