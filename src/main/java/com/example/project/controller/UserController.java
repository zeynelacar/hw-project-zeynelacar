package com.example.project.controller;

import com.example.project.model.User;
import com.example.project.model.dto.UserLoginDTO;
import com.example.project.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.signin(userLoginDTO.getUsername(),userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @DeleteMapping(value = "/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/me")
    public User whoami(HttpServletRequest req) {
        return userService.whoami(req);
    }

    @GetMapping("/get-by-username")
    public User search(@RequestParam String username){
        return userService.search(username);
    }

}
