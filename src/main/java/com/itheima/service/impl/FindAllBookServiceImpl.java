package com.itheima.service.impl;

import com.itheima.dao.FindAllBookMapper;
import com.itheima.domain.Book;
import com.itheima.service.FindAllBookService;
import com.itheima.service.FindBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllBookServiceImpl implements FindAllBookService {
    @Autowired
    private FindAllBookMapper findAllBookMapper;

    @Override
    public List<Book> FindAllBook(){
        return findAllBookMapper.FindAllBook();
    }
}
