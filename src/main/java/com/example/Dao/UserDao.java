package com.example.Dao;


import com.example.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert("insert into user (username, mail, password) values (#{username}, #{mail}, #{password})")
    public int register(@Param("username") String username, @Param("mail") String mail, @Param("password") String password);

    @Select("Select count(*) from user where id = #{id} and password = #{password}")
    public int login(@Param("id") int id, @Param("password") String password);

    @Select("Select * from book")
    public List<Book> getAll();

    @Select("Select * from book where bookname = #{bookname}")
    public List<Book> getById(@Param("bookname") String bookname);

    @Select("Select * from book where sort = #{name}")
    public List<Book> getName(@Param("name") String name);
}
