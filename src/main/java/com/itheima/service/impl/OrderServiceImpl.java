package com.itheima.service.impl;

import com.itheima.dao.OrderMapper;
import com.itheima.domain.Order2;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order2 findOrder(int bookid,int userid){
        return orderMapper.findOrder(bookid,userid);
    }

    @Override
    public int insertOrder(Order2 order){
        return orderMapper.insertOrder(order);
    }

    @Override
    public int updateOrder(Order2 order){
        return orderMapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(int id){
        return orderMapper.deleteOrder(id);
    }
}
