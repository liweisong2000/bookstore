package com.itheima.service;

import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface ShopCartService {
    List<ShopCart> findShopOrder(int userid,int status);

    int checkOut(Order2 order);
}
