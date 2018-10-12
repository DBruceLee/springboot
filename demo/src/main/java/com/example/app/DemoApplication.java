package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.demo.controller","com.example.demo.service"})
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("this is a good boy");
        System.out.println("sfs");
        SpringApplication.run(DemoApplication.class, args);
    }
}
