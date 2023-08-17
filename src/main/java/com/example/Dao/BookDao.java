package com.example.Dao;

import org.apache.ibatis.annotations.*;

@Mapper
public interface BookDao {

    @Insert("insert into book (bookname, brief, sort) values (#{bookname}, #{brief}, #{sort})")
    public int addbook(@Param("bookname") String bookname, @Param("brief") String brief, @Param("sort") String sort);

    @Insert("insert into ideas (username, idea) values (#{username}, #{idea})")
    public int quest(@Param("username") String username, @Param("idea") String idea);

    @Update("update book set brief = #{brief}, sort = #{sort} where id = #{id}")
    public int changing(@Param("brief") String brief, @Param("sort") String sort, @Param("id") int id);

    @Delete("delete from book where id = #{id}")
    public int delete(@Param("id") int id);
}
