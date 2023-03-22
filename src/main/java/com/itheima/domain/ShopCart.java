package com.itheima.domain;

import java.util.Date;

public class ShopCart {
    private int id;
    private int bookid;
    private String bookname;
    private int userid;
    private int number;
    private String address;
    private String postcode;
    private Date orderdate;
    private int status;

    public ShopCart(){
    }
    public ShopCart(int id, int bookid, String bookname, int userid, int number, String address, String postcode, Date orderdate, int status) {
        this.id = id;
        this.bookid = bookid;
        this.bookname = bookname;
        this.userid = userid;
        this.number = number;
        this.address = address;
        this.postcode = postcode;
        this.orderdate = orderdate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", userid=" + userid +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", orderdate=" + orderdate +
                ", status=" + status +
                '}';
    }
}
