package com.lytquest.testdrive.controller;

import com.lytquest.testdrive.dto.ApiResponse;
import com.lytquest.testdrive.entity.Vehicle;
import com.lytquest.testdrive.exception.ResourceNotFoundException;
import com.lytquest.testdrive.service.impl.VehicleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    private VehicleServiceImpl vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/employee/buy/vehicle/{employeeId}")
    public ApiResponse<Vehicle> employeeBuyVehicle(@RequestBody Vehicle vehicle, @PathVariable Long employeeId) throws ResourceNotFoundException {
        return new ApiResponse<>("Vehicle Purchased Successfully",false, vehicleService.employeeBuyVehicle(vehicle,employeeId));
    }

    @GetMapping("/employee/vehicles/{employeeId}")
    public ApiResponse<List<Vehicle>> employeeVehicles(@PathVariable Long id){
        return new ApiResponse<>("Vehicle List", false, vehicleService.findByEmployeeId(id));
    }
}
