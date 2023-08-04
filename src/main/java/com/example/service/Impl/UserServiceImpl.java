package com.example.service.Impl;

import com.example.Dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int Register(String mail, String username, String password){
        int register = userDao.register(mail, username, password);
        return register;
    }

    @Override
    public int Login(String mail, String password){
        int login = userDao.login(mail, password);
        return login;
    }


}
