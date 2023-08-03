package com.example.service;

public interface UserService {
    public int Register(String mail, String username, String password);
//  考虑是否添加String password来验证密码

    public int Login(String mail, String password);
}
