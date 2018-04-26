package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FreeMarkerTestController {

    @RequestMapping("/freemarkertest")
    public String hello(Map<String,Object> map) {
        map.put("name","dbx");
        return "index";

    }
}

