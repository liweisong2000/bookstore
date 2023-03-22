package com.itheima.service;

import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;

import java.util.List;

public interface StatisticService {
    List<ShopCart> findAllOrder();
}
