package com.lytquest.testdrive.service.impl;

import com.lytquest.testdrive.entity.Employee;
import com.lytquest.testdrive.exception.ResourceNotFoundException;
import com.lytquest.testdrive.repository.EmployeeRepository;
import com.lytquest.testdrive.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @CachePut(key = "#id", value = "Employee")
    public Employee updateEmployee(Employee employee, Long id) throws ResourceNotFoundException {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee Id not found"));

        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        emp.setPhone(employee.getPhone());

        return emp;
    }

    @Override
    @Cacheable(value = "Employee")
    public List<Employee> getEmployees() {
        log.info("Hitting DB");
        return employeeRepository.findAll();
    }
}
