package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindAllBookMapper {
    @Select("select * from bookinfo")
    @Results(id="bookMap",value={
            @Result(id=true,column="id",property="id"),//id=true是设置id是否为主键
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
    List<Book> FindAllBook();
}
