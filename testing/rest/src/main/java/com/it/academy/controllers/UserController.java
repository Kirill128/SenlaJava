package com.it.academy.controllers;

import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.dto.UserPetEntitysIdsDto;
import com.it.academy.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value="/{id}")
    public ModelAndView findUser(@PathVariable int id){
        UserEntityDto dto=this.userService.findUser(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user",dto);
        return modelAndView;
    }

    @GetMapping(value = "/all")
    public ModelAndView getAllUsers(){
        List<UserEntityDto>users= this.userService.getUsers();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("usersPage");
        modelAndView.addObject("usersList",users);
        return modelAndView;
    }

    @PostMapping
    public UserEntityDto createUser(@RequestBody UserEntityDto userEntityDto){
        return this.userService.createUser(userEntityDto);
    }

    @PutMapping(value = "/{id}")
    public void updateUser(@PathVariable int id,@RequestBody UserEntityDto user){
        this.userService.updateUser(id,user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id){
        this.userService.deleteUser(id);
    }

    @PatchMapping
    public void assignPetsToUser(@RequestBody UserPetEntitysIdsDto ids){

        this.userService.assignPetsToUser(ids);
    }
}
