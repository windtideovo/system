package com.example.service;

public interface BookService {

    public int Addbook(String bookname, String brief, String sort);

    public int Quest(String username, String idea);

    public int Changing(String brief, String sort, int id);

    public int Delete(int id);
}
