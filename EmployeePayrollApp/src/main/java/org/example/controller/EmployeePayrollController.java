package org.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.dto.EmployeePayrollDTO;
import org.example.dto.ResponseDTO;
import org.example.model.EmployeePayroll;
import org.example.service.EmployeePayrollService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        log.info("GET Request - Fetch all employees");
        List<EmployeePayroll> empDataList = employeePayrollService.getEmployeePayroll();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        log.info("GET Request - Fetch employee with ID: " + empId);
        EmployeePayroll empData = employeePayrollService.getEmployeePayrollById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        log.info("POST Request - Create employee: " + empPayrollDTO.getName());
        EmployeePayroll empData = employeePayrollService.createEmployeePayroll(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable("empId") int empId,
            @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        log.info("PUT Request - Update employee with ID: " + empId);
        EmployeePayroll empData = employeePayrollService.updateEmployeePayroll(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable("empId") int empId) {
        log.info("DELETE Request - Delete employee with ID: " + empId);
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Employee Payroll Data Successfully",
                "Deleted ID: " + empId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}

