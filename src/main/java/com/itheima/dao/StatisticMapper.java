package com.itheima.dao;

import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface StatisticMapper {
    @Select("select bookid,sum(number) as number from order2 where status = 1 group by bookid")
    @Results({
            @Result(column="bookid",property="bookid"),
            @Result(column="number",property="number")}
    )
    List<ShopCart> findAllOrder();
}
