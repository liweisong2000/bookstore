package com.itheima.dao;

import com.itheima.domain.Order2;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderMapper {
    @Select("select * from order2 where bookid=#{bookid} and userid=#{userid} and status = 0")
    @Results({
            @Result(column="bookid",property="bookid"),
            @Result(column="userid",property="userid"),
            @Result(column="number",property="number")}
    )
    Order2 findOrder(@Param("bookid")int bookid,@Param("userid")int userid);

    @Update("update order2 set number=#{number}+1 where bookid=#{bookid} and userid and status=0")
    int updateOrder(Order2 order);

    @Insert("insert into order2(bookid,userid,number,address,postcode,orderdate,status)"+"values(#{bookid},#{userid},#{number},#{address},#{postcode},#{orderdate},#{status})")
    int insertOrder(Order2 order);

    @Delete("delete from order2 where id=#{id}")
    int deleteOrder(int id);

}
