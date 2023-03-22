package com.itheima.service.impl;

import com.itheima.dao.ShopCartMapper;
import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;
import com.itheima.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public List<ShopCart> findShopOrder(int userid,int status){
        return shopCartMapper.findShopOrder(userid,status);
    };

    @Override
    public int checkOut(Order2 order){
        return shopCartMapper.checkOut(order);
    };
}
