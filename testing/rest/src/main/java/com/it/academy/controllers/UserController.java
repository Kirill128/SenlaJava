package com.it.academy.controllers;

import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value="/{id}")
    public UserEntityDto findUser(@PathVariable int id){
        return this.userService.findUser(id);
    }



}
