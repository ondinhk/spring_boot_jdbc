package com.odkhang.spring_jdbc.controller;

import com.odkhang.spring_jdbc.models.user.UserModel;
import com.odkhang.spring_jdbc.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/")
    public String hello() {
        return userService.hello();
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserModel newUser) {
        int id_user = userService.createUser(newUser);
        return "Create user success id=" + id_user;
    }

    @GetMapping("/user/{name}")
    public Object getUser(@PathVariable String name) {
        Optional<UserModel> data = userService.getUserByName(name);
        if (data.isEmpty()) return "Not found user " + name;
        return userService.getUserByName(name);
    }

}
