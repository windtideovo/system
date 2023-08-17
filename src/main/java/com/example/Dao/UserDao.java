package com.example.Dao;


import com.example.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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

    @Update("Update book set state = '正在借阅' where bookname = #{bookname}")
    @Update("Update borrow set borrow_date = #{borrow_date}, expiration_date = #{expiration_date}, state = '正在借阅'")
    public int update1(@Param("bookname") String username, @Param("borrow_date") Date borrow_date, @Param("expiration_date") Date expiration_date);

    @Update("Update book set state = '未借阅' where bookname = #{bookname}")
    @Update("Update borrow set return_date = #{return_date}, state = '已还书'")
    public int update2(@Param("bookname") String username, @Param("return_date") Date return_date);
}
