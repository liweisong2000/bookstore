package com.itheima.service.impl;

import com.itheima.dao.BuyMesMapper;
import com.itheima.dao.FindAllBookMapper;
import com.itheima.domain.Book;
import com.itheima.domain.ShopCart;
import com.itheima.service.BuyMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyMesServiceImpl implements BuyMesService {
    @Autowired
    private BuyMesMapper buyMesMapper;

    @Override
    public ShopCart findAllOrder(int id){
        return buyMesMapper.findAllOrder(id);
    }
}
