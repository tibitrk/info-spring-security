package com.security.spring_security_1.controller;

import com.security.spring_security_1.model.User;
import com.security.spring_security_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        System.out.println("password " + user.getPassword());

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUSer(@RequestBody User user) {
        User isExist = userService.loginUser(user.getName());
        if (isExist != null ) {
            return "success";
        } else {
            return "failure";
        }
    }
}