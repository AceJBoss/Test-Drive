package com.lytquest.testdrive.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drive")
public class DriveController {

    @PostMapping("/car")
    public String driveMe(){
        return "I drive good car";
    }
}
