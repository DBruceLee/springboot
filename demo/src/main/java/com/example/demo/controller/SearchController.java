package com.example.demo.controller;

import com.example.demo.entity.AjaxResponseBody;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.validator.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public class SearchController {

    @Autowired
    UserService userService;

}
