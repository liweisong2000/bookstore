package com.itheima.dao;

import com.itheima.domain.ShopCart;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyMesMapper {
    @Select("select * from order2 where id=#{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column="bookid",property="bookid"),
            @Result(column = "bookname",property = "bookname"),
            @Result(column = "userid",property = "userid"),
            @Result(column="number",property="number"),
            @Result(column = "address",property = "address"),
            @Result(column = "postcode",property = "postcode"),
            @Result(column = "orderdate",property = "orderdate"),
            @Result(column = "status",property = "status")
    })
    ShopCart findAllOrder(int id);
}
