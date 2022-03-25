package com.lytquest.testdrive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestDriveApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestDriveApplication.class, args);
    }

}
