package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 全局捕获异常类
@ControllerAdvice
public class GlobalExceptionHandler {
    // 如果需要返回json 格式,加上@responsebody , 返回页面,返回string类型字符串,类型结果制定404页面
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> resultError() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errorCode",500);
        map.put("errorMsg","系统错误");
        return  map;
    }
}
