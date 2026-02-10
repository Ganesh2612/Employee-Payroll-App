package org.example.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.example.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employee_payroll")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public EmployeePayroll(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    // updating the employee data
    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
        this.updatedDate = LocalDateTime.now();
    }
}


