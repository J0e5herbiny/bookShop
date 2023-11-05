package com.joe.project.controller;

import com.joe.project.dto.UserDTO;
import com.joe.project.entity.User;
import com.joe.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUsr(@PathVariable("id") Integer id){
        Optional<User> user = userService.getById(id);
        UserDTO userDTO = new UserDTO(user.get().getFirstName(), user.get().getLastName(), user.get().getEmail());
        return userDTO;
    }

    @PostMapping("/user")
    public UserDTO addUsr(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
        return userDTO;
    }

}
