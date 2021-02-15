package com.it.academy.controllers;

import com.it.academy.api.service.IUserService;
import com.it.academy.entitys.UserEntity;
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

   // public UserController(IUserService userService) {
     //   this.userService = userService;
   // }

    @GetMapping(value="/{id}")
    public UserEntity findUser(@PathVariable int id){
        System.out.printf("USERS ID --------------------------------------------");
        return this.userService.findUser(id);
    }
    @GetMapping(value="/")
    public String helloPage(){
       return "HELLO, VASA";
    }
    @GetMapping(value="")
    public String helloPage1(){
        return "HELLO, VASA";
    }

}
