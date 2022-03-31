package com.lytquest.testdrive.controller;

import com.lytquest.testdrive.dto.ApiResponse;
import com.lytquest.testdrive.entity.Employee;
import com.lytquest.testdrive.exception.ResourceNotFoundException;
import com.lytquest.testdrive.service.impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update-employee/{id}")
    public ApiResponse<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) throws ResourceNotFoundException {
        return new ApiResponse<>("Employee updated successfully", false, employeeService.updateEmployee(employee, id));
    }

    @GetMapping("/employees")
    public ApiResponse<List<Employee>> getEmployees(){
        return new ApiResponse<>("Employee List", false, employeeService.getEmployees());
    }


}
