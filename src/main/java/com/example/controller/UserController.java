package com.example.controller;

import com.example.service.UserService;
import com.example.util.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//    private jwt

    @GetMapping("/register")
    public String rigister(String mail, String username, String password) {
        int register = userService.Register(mail, username, password);
        if(register == 1){
            return "register succeed";
            //参数可调整
        }
        else{
            return "register failed";
            //参数可调整
        }
    }

    @GetMapping("/login")
    public String login(String mail, String password){
        int login = userService.Login(mail, password);
        if(login == 1){
            String token = jwt.createToken(mail, username, role);
            return token;
        }
        else{
            return "login failed";
        }
    }
}
