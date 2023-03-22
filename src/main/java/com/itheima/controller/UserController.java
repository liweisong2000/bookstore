package com.itheima.controller;


import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.ManageUserMapper;
import com.itheima.domain.Book;
import com.itheima.domain.Order2;
import com.itheima.domain.ShopCart;
import com.itheima.domain.User;
//import com.itheima.service.InsertOrderService;
import com.itheima.service.ShopCartService;
import com.itheima.service.impl.*;
import net.sf.jsqlparser.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

@Controller
public class UserController {

    @Autowired(required=false)
    private UserServiceImpl userService;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value="/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/loginServlet")
    public String loginServlet(User user, HttpServletRequest request){
        try{
            User u=userService.login(user);
            if(u!=null){
                request.getSession().setAttribute("username",u.getUsername());
                request.getSession().setAttribute("power",u.getPower());
                request.getSession().setAttribute("userid",u.getId());
                return "forward:FindOrderServlet";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("result","system wrong");
        }
        request.setAttribute("result","wrong");
        return "forward:login";
    }

    @Autowired(required=false)
    private FindUserServiceImpl findUserService;

    @RequestMapping(value="/register")
    public String details(){return "register";}

    @RequestMapping(value="/FindUserServlet")
    public String FindUser(User user, HttpServletRequest request){
        try{
            String username=request.getParameter("username");
            user= findUserService.FindUser(username);
            if(user!=null){
                request.setAttribute("Status","right");
                return "forward:registerJudge";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("result","system wrong");
        }
        request.setAttribute("Status","wrong");
        return "forward:registerJudge";
    }

    @RequestMapping(value="/RegisterServlet")
    public String Register(HttpServletRequest request){
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPwd(request.getParameter("pwd"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPostcode(request.getParameter("postcode"));
        user.setPower(0);
        int result;
        if(user.getUsername()==""||user.getPwd()==""||user.getEmail()=="") {
            return "forward:register";
        }
        else{
            result=userService.insertUser(user);
            if(result>0)
                return "forward:login";
            else
                return "forward:register";
        }
    }

    @Autowired(required=false)
    private OrderServiceImpl orderService;

    @RequestMapping(value="/MoreBook")
    public String MoreBook(){
        return "MoreBook";
    }

    @RequestMapping(value="/AddToCartServlet")
    public String AddToCart(Order2 order, HttpServletRequest request, HttpServletResponse response){
        try{
            HttpSession session = request.getSession();
            int bookid=Integer.parseInt(request.getParameter("bookid"));
            int userid=Integer.parseInt(session.getAttribute("userid").toString());
            String way=request.getParameter("way");
            order= orderService.findOrder(bookid,userid);
            int result;
            if(order!=null){
                result= orderService.updateOrder(order);
                if(result>0){
                    request.setAttribute("status","success");
                    if(way.equals("MoreBook"))
                        return "forward:MoreBook";
                    else
                        return "forward:details";
                }
                else{
                    return "forward:index";
                }
            }
            else {
                order=new Order2();
                order.setBookid(bookid);
                order.setUserid(userid);
                order.setNumber(1);
                order.setAddress("s");
                order.setPostcode("s");
                order.setOrderdate(new Date(System.currentTimeMillis()));
                order.setStatus(0);
                result=orderService.insertOrder(order);
                if(result>0){
                    if(way.equals("MoreBook"))
                        return "forward:MoreBook";
                    else
                        return "forward:details";
                }
                else{
                    return "forward:index";
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("result","system wrong");
        }
        return "test";
    }

    @RequestMapping(value="/DeleteCartServlet")
    public String DeleteCart(HttpServletRequest request){
        int deleteid=Integer.parseInt(request.getParameter("Deleteid"));
        int result=0;
        result=orderService.deleteOrder(deleteid);
        if(result>0){
            return "forward:ShopRecordServlet";
        }
        else{
            return "forward:shopcart";
        }
    }

    @Autowired
    private ShopCartServiceImpl shopCartService;

    @Autowired
    private FindBookServiceImpl findBookService;

    @RequestMapping(value="/shopcart")
    public String shopcart(){
        return "shopcart";
    }

    @RequestMapping(value="/ShopRecordServlet")
    public String ShopRecord(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        User user1 = findUserService.FindUser(username);
        List<ShopCart> shopCartList=new ArrayList<ShopCart>();
        String bookname;
        try {
            if (user1 != null) {
                shopCartList = shopCartService.findShopOrder(user1.getId(),0);
                ShopCart[] shopCarts=shopCartList.toArray(new ShopCart[shopCartList.size()]);
                for(int i=0;i<shopCarts.length;++i){
                    bookname=findBookService.FindBook(shopCarts[i].getBookid());
                    shopCarts[i].setBookname(bookname);
                }
                request.getSession().setAttribute("ShopCart", shopCarts);
                return "forward:shopcart";
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("result", "system wrong");
            return "redirect:index";
        }
    return "redirect:index";
    }

    @RequestMapping(value="/PersonMes")
    public String PersonMes(){
        return "PersonMes";
    }

    @RequestMapping(value="/FindPersonServlet")
    public String FindPerson(User user, HttpServletRequest request){
        try{
            String username=request.getSession().getAttribute("username").toString();
            user= findUserService.FindUser(username);
            if(user!=null){
                request.getSession().setAttribute("PerMes",user);
                return "forward:PersonMes";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("result","system wrong");
        }
        request.setAttribute("Status","wrong");
        return "forward:index";
    }

    @RequestMapping(value="/UpdatePerServlet")
    public String UpdatePer(User user,HttpServletRequest request){
        HttpSession session=request.getSession();
        user.setId(Integer.parseInt(session.getAttribute("userid").toString()));
        int result;
        user.setUsername(request.getParameter("username"));
        user.setPwd(request.getParameter("pwd"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPostcode(request.getParameter("postcode"));
        if(user.getUsername()==""||user.getPwd()==""||user.getEmail()=="") {
            return "forward:PersonMes";
        }
        else{
            result=userService.updatePer(user);
            if(result>0){
                return "forward:index";
            }
            else{
                return "forward:PersonMes";
            }
        }
    }

    @Autowired
    private FindAllBookServiceImpl findAllBookService;

    @RequestMapping(value="/FindAllBookServlet")
    public String FindAllBook(HttpServletRequest request){
        List<Book> bookList=new ArrayList<Book>();;
        String way=request.getParameter("way");
        bookList=findAllBookService.FindAllBook();
        if(bookList!=null){
            request.getSession().setAttribute("bookinfoList",bookList);
            if(way.equals("MoreBook")) {
                return "forward:MoreBook";
            }
            else if(way.equals("BookManage")) {
                return "forward:bookmanage";
            }
            else if(way.equals("modify")){
                return "forward:index";
            }
        }
            return "forward:test";
    }

    @RequestMapping(value="/bookmanage")
    public String bookmanage(){
        return "bookmanage";
    }

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping(value="/FindBookServlet")
    public String findBookServlet(Book book,HttpServletRequest request){
        int bookid=Integer.parseInt(request.getParameter("Modifyid"));
        book=bookService.findBookById(bookid);
        if(book!=null){
            request.getSession().setAttribute("ModBook",book);
            return "ModifyBook";
        }
        else{
            return "forward:bookmanage";
        }
    }


    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date d;

    @RequestMapping(value="/UpdateBookServlet")
    public String updateBookServlet(HttpServletRequest request){
        Book book = new Book();
        book.setId(Integer.parseInt(request.getParameter("ModBookid")));
        book.setBookname(request.getParameter("bookname"));
        book.setWriter(request.getParameter("writer"));
        book.setPublisher(request.getParameter("publisher"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPrice(Integer.parseInt(request.getParameter("price")));
        book.setRemaining(Integer.parseInt(request.getParameter("remaining")));
        String str=request.getParameter("date");

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        book.setDate(d);
        int result=bookService.updateBook(book);
        if(result>0){
            return "forward:FindAllBookServlet?way=modify";
        }
        else{
            return "test";
        }
    }

    @RequestMapping(value="/CheckOutServlet")
    public String checkOutServlet(HttpServletRequest request){
        Order2 order=new Order2();
        order.setId(Integer.parseInt(request.getParameter("id")));
        order.setAddress(request.getParameter("address"));
        order.setPostcode(request.getParameter("postcode"));
        order.setNumber(Integer.parseInt(request.getParameter("booknumber")));
        order.setStatus(1);
        order.setOrderdate(new Date(System.currentTimeMillis()));
        String Buybookname=request.getParameter("bookname");
        int result=shopCartService.checkOut(order);
        if(result>0){
            request.getSession().setAttribute("Buybookname", Buybookname);
            return "forward:FindOrderServlet";
        }
        else{
            return "forward:shopcart";
        }
    }

    @RequestMapping(value="/FindOrderServlet")
    public String findOrderServlet(HttpServletRequest request){
        HttpSession session=request.getSession();
        int userid=0;
        userid=Integer.parseInt(session.getAttribute("userid").toString());
        List<ShopCart> shopCartList=new ArrayList<ShopCart>();
        String bookname;
        try {
            if (userid>0) {
                shopCartList = shopCartService.findShopOrder(userid,1);
                ShopCart[] shopCarts=shopCartList.toArray(new ShopCart[shopCartList.size()]);
                for(int i=0;i<shopCarts.length;++i){
                    bookname=findBookService.FindBook(shopCarts[i].getBookid());
                    shopCarts[i].setBookname(bookname);
                }
                request.getSession().setAttribute("BuyMes", shopCarts);
                return "forward:index";
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("result", "system wrong");
        }
        return "redirect:index";
    }

    @RequestMapping(value="/DeleteBookServlet")
    public String DeleteBook(HttpServletRequest request){
        int DeleteID=Integer.parseInt(request.getParameter("Deleteid"));
        int result=0;
        result=bookService.deleteBook(DeleteID);
        if(result>0){
            return "forward:FindAllBookServlet?way=BookManage";
        }
        else{
            return "forward:bookmanage";
        }
    }

    @RequestMapping(value="/insertbook")
    public String insertbookJsp(){
        return "insertbook";
    }

    @RequestMapping(value="/InsertBookServlet")
    public String InsertBook(HttpServletRequest request){
        int result=0;
        Book book=new Book();
        book.setBookname(request.getParameter("bookname"));
        book.setIsbn(request.getParameter("isbn"));
        book.setWriter(request.getParameter("writer"));
        book.setPublisher(request.getParameter("publisher"));
        book.setIntro(request.getParameter("intro"));
        book.setPrice(Integer.parseInt(request.getParameter("price")));
        book.setRemaining(Integer.parseInt(request.getParameter("remaining")));
        book.setDate(new Date(System.currentTimeMillis()));
        result=bookService.insertBook(book);
        if(result>0){
            return "forward:FindAllBookServlet?way=BookManage";
        }
        else{
            return "forward:insertbook";
        }
    }

    @RequestMapping(value="/CancelUserServlet")
    public String cancelUser(HttpServletRequest request){
        Enumeration em = request.getSession().getAttributeNames();
        while (em.hasMoreElements())
        {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "forward:index";
    }

    @RequestMapping(value="/data")
    public String dataJsp(){
        return "data";
    }

    @Autowired
    private StatisticServiceImpl statisticService;

    @RequestMapping(value="/StatisticServlet")
    public String statistics(HttpServletRequest request) throws JsonProcessingException {
        List<ShopCart> shopCartList=new ArrayList<ShopCart>();
        Book book=new Book();
        shopCartList=statisticService.findAllOrder();
        if(shopCartList!=null){
            ShopCart[] shopCarts=shopCartList.toArray(new ShopCart[shopCartList.size()]);
            for(int i=0;i<shopCarts.length;++i){
                book=bookService.findBookById(shopCarts[i].getBookid());
                shopCarts[i].setBookname(book.getBookname());
            }
            List<ShopCart> list2 = stream(shopCarts).collect(Collectors.toList());
            ObjectMapper om= new ObjectMapper();
            String json=om.writeValueAsString(list2);
            System.out.println("实体类转Json:"+json);
            request.getSession().setAttribute("json",json);
            return "forward:data";
        }
        else{
            return "index";
        }
    }

    @RequestMapping(value="/test")
    public String returntest(){
        return "test";
    }

    @Autowired
    private BuyMesServiceImpl buyMesService;

    @RequestMapping(value="/ShowBuyMesServlet")
    public String showBuyMes(ShopCart shopCart,HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("BuyMesid"));
        String bookname=request.getParameter("Buybookname");
        shopCart=buyMesService.findAllOrder(id);
        if(shopCart!=null) {
            shopCart.setBookname(bookname);
            request.getSession().setAttribute("OrderDetail", shopCart);
            return "forward:orderDetails";
        }
        return "index";
    }

    @RequestMapping(value="/orderDetails")
    public String orderDetails(){
        return "orderDetails";
    }

    @Autowired
    private ManageUserMapperServiceImpl manageUserMapperService;

    @RequestMapping(value="/FindAllUsersServlet")
    public String findAllUsers(HttpServletRequest request){
        List<User> userList=new ArrayList<User>();
        userList=manageUserMapperService.FindUser();
        if(userList!=null){
            User[] users=userList.toArray(new User[userList.size()]);
            request.getSession().setAttribute("UserList",users);
            return "forward:usermanage";
        }
        return "index";
    }

    @RequestMapping(value="/usermanage")
    public String userManage(){
        return "usermanage";
    }

    @RequestMapping(value="/FindUsersServlet")
    public String findUser(HttpServletRequest request){
        String username=request.getParameter("UserName");
        User user=findUserService.FindUser(username);
        if(user!=null){
            request.getSession().setAttribute("UserMes",user);
            return "forward:UserMes";
        }
        return "index";
    }

    @RequestMapping(value="/UserMes")
    public String userMes(){
        return "UserMes";
    }

    @RequestMapping(value="/UpdateUserServlet")
    public String updateUser(HttpServletRequest request){
        User user=new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setPwd(request.getParameter("pwd"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPostcode(request.getParameter("postcode"));
        int result;
        if(user.getUsername()==""||user.getPwd()==""||user.getEmail()=="") {
            return "forward:UserMes";
        }
        else{
            result=userService.updatePer(user);
            if(result>0){
                return "forward:FindAllUsersServlet";
            }
            return "forward:UserMes";
        }
    }

    @RequestMapping(value="/DeleteUserServlet")
    public String deleteUser(HttpServletRequest request){
        String username=request.getParameter("DeleteName");
        int result=findUserService.DeleteUser(username);
        if(result>0){
            return "forward:FindAllUsersServlet";
        }
        return "forward:index";
    }
}
