package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.demo.controller")
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("this is a good boy");
        SpringApplication.run(DemoApplication.class, args);
    }
}
