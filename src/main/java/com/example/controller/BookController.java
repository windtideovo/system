package com.example.controller;


import com.example.domain.Book;
import com.example.service.BookService;
import com.example.service.Impl.BookServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    //所有图书
    @GetMapping
        public List<Book> getAll() {
            List<Book> search = userService.getAll();
            return search;
    }

    //查询图书
    @GetMapping("/bookname")
        public List<Book> getById(String bookname) {
            List<Book> search = userService.getById(bookname);
            return search;
    }

    //查询图书类
    @GetMapping("/sort")
        public List<Book> getName(String name) {
            List<Book> search = userService.getName(name);
            return search;
    }

    //添加图书
    @PostMapping("/add")
        public String Addbook (String bookname, String brief, String sort) {
            int addbook = bookService.Addbook(bookname, brief, sort);
            if(addbook == 1) {
                return "Add succeed";
            }
            else {
                return "Add failed";
            }
    }

    //提出反馈
    @PostMapping("/quest")
        public String Quest (String username, String idea) {
            int quest = bookService.Quest(username, idea);
            if(quest == 1) {
                return "Quest getting succeed";
            }
            else {
                return "Quest getting failed";
            }
    }
}