package com.example.controller;


import com.example.domain.Book;
import com.example.service.BookService;
import com.example.service.Impl.BookServiceImpl;
import com.example.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    //修改图书
    @PutMapping("/changing")
        public String Changing (String brief, String sort, int id) {
            int changing = bookService.Changing(brief, sort, id);
            if(changing == 1) {
                return "changing succeed";
            }
            else {
                return "changing failed";
            }
    }

    //删除图书
    @DeleteMapping("/delete")
        public String Delete (int id) {
            int delete = bookService.Delete(id);
            if(delete == 1) {
                return "delete succeed";
            }
            else {
                return "delete fail";
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

    //借书
    @PutMapping("/borrow")
        public String Update1 (String bookname, Date borrow_date, Date expiration_date) {
            int update1 = userService.Update1(bookname, borrow_date, expiration_date);
            if(update1 == 1) {
                return "borrow succeed";
            }
            else {
                return "borrow failed";
            }
    }

    //还书
    @PutMapping("/return")
    public String Update2 (String bookname, Date return_date) {
        int update2 = userService.Update2(bookname, return_date);
        if(update2 == 1) {
            return "return succeed";
        }
        else {
            return "return failed";
        }
    }
}