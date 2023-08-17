package com.example.service;

import com.example.domain.Book;
import com.example.domain.BookSort;

import java.util.Date;
import java.util.List;

public interface UserService {
    public int Register(String username, String mail, String password);
//  考虑是否添加String password来验证密码

    public int Login(int id, String password);

    public List<Book> getAll();

    public List<Book> getById(String bookname);

    public List<Book> getName(String name);

    public int Update1(String bookname, Date borrow_date, Date expiration_date);

    public int Update2(String bookname, Date return_date);
}
