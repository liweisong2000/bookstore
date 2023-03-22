package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.impl.BookDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookDetailController {

    @Autowired(required=false)
    private BookDetailServiceImpl bookDetailService;

    @RequestMapping(value="/details")
    public String details(){return "details";}

    @RequestMapping(value="/BookDetailServlet")
    public String BookDetail(Book book, HttpServletRequest request){
        try{
            Book b=bookDetailService.BookDetail(book);
            if(b!=null){
                request.setAttribute("BookDet",b);
                return "details";
            }
            request.setAttribute("result","wrong");
            return "index";
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("result","system wrong");
            return "index";
        }
    }

}
