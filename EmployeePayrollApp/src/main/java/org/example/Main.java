package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

@Slf4j
public class Main {
    public static void main(String[] args) {
            log.info("Starting Employee Payroll Application...");
            SpringApplication.run(Main.class, args);
            log.info("Employee Payroll Application Started Successfully!");
    }
}