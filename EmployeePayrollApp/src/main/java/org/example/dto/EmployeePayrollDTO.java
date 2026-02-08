package org.example.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot be null or empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
            message = "Employee name is invalid. It should start with a capital letter and have at least 3 characters")
    private String name;

    @Min(value = 500, message = "Minimum salary should be more than 500")
    private double salary;
}

