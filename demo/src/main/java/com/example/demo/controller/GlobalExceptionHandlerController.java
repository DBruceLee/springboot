package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> resultError(Exception e) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (e instanceof ArithmeticException) {
            map.put("errorCode", 500);
            map.put("errorMsg", "分母不能为0");
        } else if (e instanceof NullPointerException) {
            map.put("errorCode", 500);
            map.put("errorMsg", "空指针异常");
        } else {
            map.put("errorCode", 500);
            map.put("errorMsg", "未知异常");
        }
        return map;
    }
}


