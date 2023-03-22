package com.itheima.dao;

import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public interface ShopCartMapper {
    @Select("select * from order2 where userid=#{userid} and status=#{status}")
    @Results({
            @Result(column="id",property="id"),
            @Result(column="bookid",property="bookid"),
           /* @Result(column = "bookname",property="bookname"),*/
            @Result(column="userid",property="userid"),
            @Result(column="number",property="number"),
            @Result(column = "address",property="address"),
            @Result(column="postcode",property="postcode"),
            @Result(column="orderdate",property="orderdate"),
            @Result(column="status",property="status")
    })
    List<ShopCart> findShopOrder(@Param("userid")int userid, @Param("status")int status);

    @Update("update order2 set number=#{number}, address=#{address}, postcode=#{postcode}, status=#{status},orderdate=#{orderdate} where id=#{id}")
    int checkOut(Order2 order);
}
