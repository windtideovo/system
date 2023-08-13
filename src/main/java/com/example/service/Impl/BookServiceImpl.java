package com.example.service.Impl;

import com.example.Dao.BookDao;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public int Addbook(String bookname, String brief, String sort) {
        int addbook = bookDao.addbook(bookname, brief, sort);
        return addbook;
    }

    public int Quest(String username, String idea) {
        int quest = bookDao.quest(username, idea);
        return quest;
    }
}
