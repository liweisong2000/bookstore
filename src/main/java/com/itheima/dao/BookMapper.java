package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    @Select("select * from bookinfo where id=#{bookid}")
    @Results(id="findById",value={
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
    Book findBookById(int bookid);

    @Update("update bookinfo set bookname=#{bookname},writer=#{writer},publisher=#{publisher},isbn=#{isbn},price=#{price},remaining=#{remaining},date=#{date},intro=#{intro} where id=#{id}")
    int updateBook(Book book);

    @Delete("delete from bookinfo where id=#{id}")
    int deleteBook(int id);

    @Insert("insert into bookinfo(bookname,isbn,writer,publisher,intro,price,remaining,date)values(#{bookname},#{isbn},#{writer},#{publisher},#{intro},#{price},#{remaining},#{date})")
    int insertBook(Book book);
}
