package org.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.dto.EmployeePayrollDTO;
import org.example.exception.EmployeePayrollException;
import org.example.model.EmployeePayroll;
import org.example.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    // get all employees data
    @Override
    public List<EmployeePayroll> getEmployeePayroll() {
        log.info("Fetching all employee payroll data");
        return employeePayrollRepository.findAll();
    }

    //get employee data by id
    @Override
    public EmployeePayroll getEmployeePayrollById(int empId) {
        log.info("Fetching employee payroll data for ID: " + empId);
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + empId + " not found"));
    }

    // create a new employee data
    @Override
    public EmployeePayroll createEmployeePayroll(EmployeePayrollDTO empPayrollDTO) {
        log.info("Creating new employee payroll data for: " + empPayrollDTO.getName());
        EmployeePayroll empData = new EmployeePayroll(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    //update the employee data details
    @Override
    public EmployeePayroll updateEmployeePayroll(int empId, EmployeePayrollDTO empPayrollDTO) {
        log.info("Updating employee payroll data for ID: " + empId);
        EmployeePayroll empData = this.getEmployeePayrollById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }
    
    // delete the employee data by id
    @Override
    public void deleteEmployeePayrollData(int empId) {
        log.info("Deleting employee payroll data for ID: " + empId);
        EmployeePayroll empData = this.getEmployeePayrollById(empId);
        employeePayrollRepository.delete(empData);
    }
}


