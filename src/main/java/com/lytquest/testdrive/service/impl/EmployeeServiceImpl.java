package com.lytquest.testdrive.service.impl;

import com.lytquest.testdrive.entity.Employee;
import com.lytquest.testdrive.repository.EmployeeRepository;
import com.lytquest.testdrive.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
