package com.example.service.Impl;

import com.example.Dao.UserDao;
import com.example.domain.Book;
import com.example.domain.BookSort;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int Register(String username, String mail, String password) {
        int register = userDao.register(username, mail, password);
        return register;
    }

    @Override
    public int Login(int id, String password) {
        int login = userDao.login(id, password);
        return login;
    }

    public List<Book> getAll(){
        return userDao.getAll();
    }

    public List<Book> getById(String bookname) { return userDao.getById(bookname);
    }

    public List<Book> getName(String name) { return userDao.getName(name);}

    @Override
    public int Update1(String bookname, Date borrow_date, Date expiration_date) {
        int update1 = userDao.update1(bookname, borrow_date, expiration_date);
        return update1;
    }

    @Override
    public int Update2(String bookname, Date return_date) {
        int update2 = userDao.update2(bookname, return_date);
        return update2;
    }
}
