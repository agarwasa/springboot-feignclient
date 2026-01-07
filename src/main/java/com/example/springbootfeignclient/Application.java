package com.example.springbootfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        System.out.println("Starting Spring Boot Application...");
        System.out.println("Initializing Spring context...");
        SpringApplication.run(Application.class, args);
    }
}

