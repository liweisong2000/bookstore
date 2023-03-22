package com.itheima.service;

import com.itheima.domain.Book;

public interface BookService {
    Book findBookById(int bookid);

    int updateBook(Book book);

    int deleteBook(int id);

    int insertBook(Book book);
}
