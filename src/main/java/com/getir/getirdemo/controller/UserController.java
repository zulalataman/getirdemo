package com.getir.getirdemo.controller;

import com.getir.getirdemo.model.User;
import com.getir.getirdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{mail}")
    public User deleteUserByMail(@PathVariable String mail) {
        return userService.deleteUserByMail(mail);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }
}
