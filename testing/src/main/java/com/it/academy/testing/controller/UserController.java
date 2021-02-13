package com.it.academy.testing.controller;

import com.it.academy.testing.entity.UserEntity;
import com.it.academy.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public List<UserEntity> getAllUsers(){
        return userService.getUsers();
    }
}
