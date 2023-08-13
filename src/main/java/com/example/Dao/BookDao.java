package com.example.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookDao {

    @Insert("insert into book (bookname, brief, sort) values (#{bookname}, #{brief}, #{sort})")
    public int addbook(@Param("bookname") String bookname, @Param("brief") String brief, @Param("sort") String sort);

    @Insert("insert into ideas (username, idea) values (#{username}, #{idea})")
    public int quest(@Param("username") String username, @Param("idea") String idea);
}
