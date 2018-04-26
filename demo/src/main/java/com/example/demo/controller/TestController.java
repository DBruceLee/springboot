package com.example.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }

    @RequestMapping("/index")
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", 200);
        map.put("errorMsg", "成功");
        return map;
    }
}
