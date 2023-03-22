package com.itheima.service.impl;

import com.itheima.dao.StatisticMapper;
import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;
import com.itheima.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public List<ShopCart> findAllOrder(){
        return statisticMapper.findAllOrder();
    };
}
