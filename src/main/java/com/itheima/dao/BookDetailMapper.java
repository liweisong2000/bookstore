package com.itheima.dao;

import com.itheima.domain.Book;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailMapper {
    @Select("select * from bookinfo where bookname=#{bookname}")
    @Results(id="bookDetailMap",value={
            @Result(id=false,column="id",property="id"),
            @Result(column="bookname",property="bookname"),
            @Result(column="isbn",property="isbn"),
            @Result(column="writer",property="writer"),
            @Result(column="publisher",property="publisher"),
            @Result(column="intro",property = "intro"),
            @Result(column="price",property="price"),
            @Result(column="remaining",property = "remaining"),
            @Result(column="picture",property = "picture"),
            @Result(column="date",property = "date")
    })
    Book BookDetail(Book book);
}
