package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String hello(Map<String, Object> map) {
        int i = 1/0;
//        String a = null;
        System.out.println(i);
//        map.put("name", "dbstar");
//        map.put("sex", 1);    //sex:性别，1：男；0：女；
//
//        // 模拟数据
//        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
//        Map<String, Object> friend = new HashMap<String, Object>();
//        friend.put("name", "dbstar");
//        friend.put("age", 22);
//        friends.add(friend);
//        friend = new HashMap<String, Object>();
//        friend.put("name", "chicken.zhao");
//        friend.put("age", 18);
//        friends.add(friend);
//        map.put("friends", friends);
//        return "test/hello";
        return "freemarker/hello";
//        return "hello";
    }

}
