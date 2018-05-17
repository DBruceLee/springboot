package com.example.demo.controller;

import com.example.demo.entity.AjaxResponseBody;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.validator.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
//@RestController
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
    @RequestMapping("/createUser/{method}")
    public ModelAndView createUser(@PathVariable String method, Integer id, String name, Integer age) {
        ModelAndView mav = new ModelAndView();
        userService.createUser(id, name, age);
        mav.addObject("method", method);
        mav.setViewName("user/hello");
        return mav;
    }

    /**
     * @Description: 根据ID查找一个用户
     * @Param: [id]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:17
     **/
    @RequestMapping("/findUserById/{method}")
//    public ModelAndView findUserById(@PathVariable String method, Integer id) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("user", userService.findUserById(id));
//        mav.addObject("id", id);
//        mav.addObject("method", method);
//        mav.setViewName("user/user");
    public String findUserById(@PathVariable String method, Integer id, Map mav) {
//        Map mav = new HashMap();
        mav.put("user", userService.findUserById(id));
        mav.put("id", id);
        mav.put("method", method);
        mav.put("test", "dbxtest");
        return "user/user";
    }

    /**
     * @Description: 返回所有的用户信息
     * @Param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:19
     **/
    @RequestMapping("/findUserList/{method}")
    public ModelAndView findUserList(@PathVariable String method) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("userList", userService.findUsers());
        mav.addObject("user", userService.findUsers().get(0));
        mav.addObject("method", method);
        mav.setViewName("user/user");

        return mav;
    }

    /**
     * @Description: 根据用户名查找用户
     * @Param: [search, errors]
     * @return: org.springframework.http.ResponseEntity<?>
     * @Author: dbstar
     * @Date: 2018/5/17 下午6:06
     **/
    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }

        List<User> users = userService.findUserByName(search.getUsername());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);
    }

    /**
     * @Description: 根据主键删除用户
     * @Param: [id, method]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: dbstar
     * @Date: 2018/4/30 上午11:26
     **/
    @RequestMapping("/deleteUserById/{method}")
    public ModelAndView deleteUser(Integer id, @PathVariable String method) {
        int i = userService.deleteUser(id);
        System.out.println("影响的行数为" + i);
        ModelAndView mav = new ModelAndView();
        mav.addObject("method", method);
        mav.setViewName("user/user");
        return mav;
    }

    /**
     * @Description: 根据主键删除用户
     * @Param: [method, id, name, age]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: dbstar
     * @Date: 2018/4/30 上午11:54
     **/
    @RequestMapping("/updateUserById/{method}/{id}/{name}/{age}")
    public ModelAndView updateUserById(@PathVariable String method, @PathVariable Integer id, @PathVariable String name, @PathVariable Integer age) {
        int i = userService.updateUser(id, name, age);
        System.out.println("影响的行数为:" + i);
        ModelAndView mav = new ModelAndView();
        mav.addObject("method", method);
        mav.addObject("result", i);
        mav.setViewName("user/user");
        return mav;

    }

}
