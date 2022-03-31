package com.lytquest.testdrive.service;

import com.lytquest.testdrive.entity.Employee;
import com.lytquest.testdrive.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id) throws ResourceNotFoundException;
    List<Employee> getEmployees();
}
