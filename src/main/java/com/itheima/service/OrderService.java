package com.itheima.service;

import com.itheima.domain.Order2;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    Order2 findOrder(int bookid,int userid);

    int insertOrder(Order2 order);

    int updateOrder(Order2 order);

    int deleteOrder(int id);

}
