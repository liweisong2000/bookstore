package com.itheima.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private Integer id;
    private String bookname;
    private String isbn;
    private String writer;
    private String publisher;
    private String intro;
    private Integer price;
    private Integer remaining;
    private String picture;
    private Date date;

    public Book(){}

    public Book(Integer id, String bookname, String isbn, String writer, String publisher, String intro, Integer price, Integer remaining, String picture, Date date) {
        this.id = id;
        this.bookname = bookname;
        this.isbn = isbn;
        this.writer = writer;
        this.publisher = publisher;
        this.intro = intro;
        this.price = price;
        this.remaining = remaining;
        this.picture = picture;
        this.date = date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", isbn='" + isbn + '\'' +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", intro='" + intro + '\'' +
                ", price=" + price +
                ", remaining=" + remaining +
                ", picture='" + picture + '\'' +
                ", date=" + date +
                '}';
    }
}
