package com.lytquest.testdrive.controller;

import com.lytquest.testdrive.dto.ApiResponse;
import com.lytquest.testdrive.entity.Employee;
import com.lytquest.testdrive.service.impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/create-employee")
    public ApiResponse<Employee> createEmployee(@RequestBody Employee employee){
        return new ApiResponse<>("Employee Created Successfully", false, employeeService.createEmployee(employee));
    }
}
