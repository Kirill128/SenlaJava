package com.it.academy.controllers;

import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.dto.UserPetEntitysIdsDto;
import com.it.academy.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value="/{id}")
    public UserEntityDto findUser(@PathVariable int id){
        return this.userService.findUser(id);
    }

    @GetMapping(value = "all")
    public List<UserEntityDto> getAllUsers(){
        return this.userService.getUsers();
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
