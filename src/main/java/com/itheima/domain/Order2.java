package com.itheima.domain;

import java.util.Date;

public class Order2 {
    private Integer id;
    private Integer bookid;
    private Integer userid;
    private Integer number;
    private String address;
    private String postcode;
    private Date orderdate;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order2{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", userid=" + userid +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", orderdate=" + orderdate +
                ", status=" + status +
                '}';
    }
}
