package com.itheima.service.impl;

import com.itheima.dao.FindBookMapper;
import com.itheima.domain.ShopCart;
import com.itheima.service.FindBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class FindBookServiceImpl implements FindBookService {

    @Autowired
    private FindBookMapper findBookMapper;

    @Override
    public String FindBook(int bookid){return findBookMapper.FindBook(bookid);}
}
