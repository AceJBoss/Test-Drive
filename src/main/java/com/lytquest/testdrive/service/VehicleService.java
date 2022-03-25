package com.lytquest.testdrive.service;

import com.lytquest.testdrive.entity.Vehicle;
import com.lytquest.testdrive.exception.ResourceNotFoundException;

import java.util.List;

public interface VehicleService {
    Vehicle employeeBuyVehicle(Vehicle vehicle, Long employeeId) throws ResourceNotFoundException;
    List<Vehicle> findByEmployeeId(Long id);
}
