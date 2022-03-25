package com.lytquest.testdrive.service.impl;

import com.lytquest.testdrive.entity.Vehicle;
import com.lytquest.testdrive.exception.ResourceNotFoundException;
import com.lytquest.testdrive.repository.EmployeeRepository;
import com.lytquest.testdrive.repository.VehicleRepository;
import com.lytquest.testdrive.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private EmployeeRepository employeeRepository;

   public VehicleServiceImpl(EmployeeRepository employeeRepository, VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Vehicle employeeBuyVehicle(Vehicle vehicle, Long employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId).map(emp->{
            vehicle.setEmployee(emp);
            return vehicleRepository.save(vehicle);
        }).orElseThrow(()-> new ResourceNotFoundException("Employee Id " + employeeId + "does not exist"));

    }

    @Override
    public List<Vehicle> findByEmployeeId(Long id) {
        return vehicleRepository.findByEmployeeId(id);
    }
}
