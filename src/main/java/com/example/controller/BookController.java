package com.example.controller;


import com.example.domain.Book;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private UserService userService;

    @GetMapping
        public List<Book> getById(String bookname) {
            List<Book> search = userService.getById(bookname);
            return search;
    }
}