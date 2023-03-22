package com.itheima.service.impl;

import com.itheima.dao.BookMapper;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findBookById(int bookid){
        return bookMapper.findBookById(bookid);
    };

    @Override
    public int updateBook(Book book){
        return bookMapper.updateBook(book);
    }

    @Override
    public int deleteBook(int id){
        return bookMapper.deleteBook(id);
    };

    @Override
    public int insertBook(Book book){
        return bookMapper.insertBook(book);
    }
}
