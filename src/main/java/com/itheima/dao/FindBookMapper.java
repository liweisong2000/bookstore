package com.itheima.dao;

import com.itheima.domain.ShopCart;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface FindBookMapper {
    @Select("select * from bookinfo where id=#{bookid}")
    @Results(id="ShopCartMap",value={
            @Result(column="bookname",property="bookname")
    })
    String FindBook(int bookid);


}
