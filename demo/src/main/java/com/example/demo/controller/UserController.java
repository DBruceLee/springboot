package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Description: 新增用户
     * @Param: [id, name, age]
     * @return: java.lang.String
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:17
     **/
    @RequestMapping("/createUser")
    public String createUser(Integer id, String name, Integer age) {
        userService.createUser(id, name, age);
        return "user/hello";
    }

    /**
     * @Description: 根据ID查找一个用户
     * @Param: [id]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:17
     **/
    @RequestMapping("/findUserById")
    public ModelAndView findUserById(Integer id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", userService.findUserById(id));
        mav.addObject("id", id);
        mav.setViewName("user/user");
        return mav;
    }

    /**
     * @Description: 返回所有的用户信息
     * @Param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:19
     **/
    @RequestMapping("/findUserList")
    public ModelAndView findUserList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("userList", userService.findUsers());
        mav.addObject("user",userService.findUsers().get(0));
        mav.setViewName("user/user");
        return mav;
    }
}
