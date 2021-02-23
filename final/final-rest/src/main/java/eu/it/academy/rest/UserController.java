package eu.it.academy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.it.academy.api.dto.UserDto;
import eu.it.academy.api.dto.UserPetIdsDto;
import eu.it.academy.api.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @GetMapping
    public List<UserDto> findUsers() {
        return userService.getUsers();
    }
    
    @GetMapping(value = "/{id}")
    public UserDto findUser(@PathVariable int id) {
        return userService.findUser(id);
    }
    
    @GetMapping(value = "/name/{firstName}")
    public UserDto findUserByFirstName(@PathVariable String firstName) {
        return userService.findUserByFirstName(firstName);
    }
    
    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return this.userService.createUser(user);
    }
    
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
