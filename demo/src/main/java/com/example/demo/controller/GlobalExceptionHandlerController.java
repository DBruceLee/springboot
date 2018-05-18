package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> resultError(HttpServletRequest request, Exception e) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (e instanceof ArithmeticException) {
            map.put("errorCode", 500);
            map.put("errorMsg", "分母不能为0");
        } else if (e instanceof NullPointerException) {
            map.put("errorCode", 500);
            map.put("errorMsg", "空指针异常");
        } else if (e instanceof MultipartException) {
            map.put("errorCode", 500);
            map.put("errorMsg", "文件上传异常：Attachment size exceeds the allowable limit! (10MB)");

        } else {
            map.put("errorCode", 500);
            map.put("errorMsg", "未知异常");
        }
        System.out.println("you are assssss good boy");
        return map;
    }

}


