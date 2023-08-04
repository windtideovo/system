package com.example.Dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserDao {

    @Insert("insert into user (mail, username, password) values (#{mail}, #{username}, #{password}")//查
    public abstract int register(@Param("mail") String mail, @Param("username") String username, @Param("password") String password);
    //查一下AI，应为封装用户信息

    @Select("Select count(*) from user where mail = #{mail} and password = #{password}")//查
    public abstract int login(@Param("mail") String mail, @Param("password") String password);


}
