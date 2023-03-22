package com.itheima.service.impl;

import com.itheima.dao.BookDetailMapper;
import com.itheima.domain.Book;
import com.itheima.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailServiceImpl implements BookDetailService {
    @Autowired
    private BookDetailMapper bookMapper;

    @Override
    public Book BookDetail(Book book){
        return bookMapper.BookDetail(book);
    }
}
