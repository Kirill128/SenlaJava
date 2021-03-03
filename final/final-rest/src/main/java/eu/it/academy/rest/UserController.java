package eu.it.academy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import eu.it.academy.api.dto.UserDto;
import eu.it.academy.api.dto.UserPetIdsDto;
import eu.it.academy.api.mappers.UserMapper;
import eu.it.academy.api.services.IUserService;
import eu.it.academy.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @GetMapping
    public ModelAndView findUsers() {
        List<UserDto> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersPage");
        modelAndView.addObject("title", "My Users:");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }
    
    @GetMapping(value = "/{id}")
    public ModelAndView findUser(@PathVariable int id) {
        UserDto user = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    
    @GetMapping(value = "/name/{firstName}")
    public UserDto findUserByFirstName(@PathVariable String firstName) {
        return userService.findUserByFirstName(firstName);
    }
    
    //================================
    
    @GetMapping(value = "/add")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersFormPage");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }
    @PostMapping(value = "/add")
    public UserDto createUserSubmit(UserDto user) {
        return this.userService.createUser(user);
    }
    
  //================================
    
    @PutMapping(value = "/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserDto user) {
        this.userService.updateUser(id, user);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
    
    @PatchMapping()
    public void assingPetToUser(@RequestBody UserPetIdsDto ids) {
        this.userService.assingPetToUser(ids);
    }
}
