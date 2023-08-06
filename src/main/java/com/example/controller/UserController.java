package com.example.controller;

import com.example.service.UserService;
import com.example.util.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")
    public String register(String username, String mail, String password) {
        int register = userService.Register(username, mail, password);
        if(register == 1){
            return "register succeed";
        }
        else{
            return "register failed";
        }
    }

    //登录
    @GetMapping("/login")
    public String login(int id, String password) {
        int login = userService.Login(id, password);
        if(login == 1){
            String token = jwt.createToken("mail", "username", "role");
            return token;
        }
        else{
            return "login failed";
        }
    }

}