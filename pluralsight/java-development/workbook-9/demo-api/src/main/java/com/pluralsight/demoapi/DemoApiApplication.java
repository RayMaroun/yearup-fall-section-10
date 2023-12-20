package com.pluralsight.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// This annotation marks the class as a Spring Boot application. It enables auto-configuration, component scanning, and other Spring Boot features.
public class DemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args); // This line launches the Spring Boot application. It starts the embedded server, initializes Spring application context, and performs other bootstrap operations.
    }

}
