package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.curd.model.User;
import com.curd.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "http://localhost:5175",
    "http://localhost:5176",
    "https://tomatowebsites.netlify.app"
})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody User user) {
        return userService.verifyOtp(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}