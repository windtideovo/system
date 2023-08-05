package com.example.service;

import com.example.domain.Book;

import java.util.List;

public interface UserService {
    public int Register(String username, String mail, String password);
//  考虑是否添加String password来验证密码

    public int Login(int id, String password);

    public List<Book> getById(String bookname);
}
