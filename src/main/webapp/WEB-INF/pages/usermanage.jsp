<%--
  Created by IntelliJ IDEA.
  User: 宋轹蔚
  Date: 2022/5/26
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息管理</title>
    <link rel="stylesheet" type="text/css" href="css/usermanage.css">
</head>
<body>
<div class="head">
    <img class="pic1" src="image/BookStore.png" /> <img class="pic2"
                                                        src="image/求知书屋.png" />

    <form class="search" action="#" method="post">
        <input class="s1" type="text" placeholder="书名/作者"> <img
            class="searchp" src="image/search.png" alt="" /> <input class="sea"
                                                                    type="submit" value="搜索" />
    </form>

    <c:set var="USER" scope="session" value="${username}" />
    <c:choose>
        <c:when test="${not empty USER}">
            <p
                    style="position: absolute; right: 100px; top: 28px; font-size: 20px;">欢迎光临，尊敬的${USER}客户</p>
        </c:when>
        <c:otherwise>
            <button class="log">
                <a style="color: white;"
                   href="${pageContext.request.contextPath}/register">注册</a>/ <a
                    style="color: white;"
                    href="${pageContext.request.contextPath}/login">登录</a>
            </button>
        </c:otherwise>
    </c:choose>
</div>

<div class="center">
    <c:set var="power" scope="session" value="${power}" />

    <c:choose>
        <c:when test="${power ==null}">
            <button class="b1" onclick="window.location='index'">首页</button>
        </c:when>
        <c:when test="${power eq 1}">
            <button class="b1" onclick="window.location='index'">首页</button>
            <button class="b2" onclick="window.location='FindAllUsersServlet'">用户信息</button>
            <button class="b3" onclick="window.location='FindAllBookServlet?way=BookManage'">图书管理</button>
            <button class="b4" onclick="window.location='FindPersonServlet'">个人资料</button>
            <button class="b5" onclick="window.location='ShopRecordServlet'">购物车</button>
            <button class="b6" onclick="window.location='StatisticServlet'">购买统计</button>
            <button class="b7" onclick="window.location='CancelUserServlet'">注销</button>
            <button class="b8" onclick="window.location='register'">注册</button>
        </c:when>
        <c:otherwise>
            <button class="b1" onclick="window.location='index'">首页</button>
            <button class="b2" onclick="window.location='FindPersonServlet'">个人资料</button>
            <button class="b3" onclick="window.location='ShopRecordServlet'">购物车</button>
            <button class="b4" onclick="window.location='CancelUserServlet'">注销</button>
            <button class="b5" onclick="window.location='register'">注册</button>
        </c:otherwise>
    </c:choose>
</div>

<table class="userma" width="72%" border="1" align="center">
    <c:forEach items="${UserList}" var="Users">
        <tr>
            <th width="20%" rowspan="1">
                    ${Users.username}

            </th>
            <td width="65%">
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/FindUsersServlet?UserName=${Users.username}">修改</a>&nbsp;
                        <a href="${pageContext.request.contextPath}/DeleteUserServlet?DeleteName=${Users.username}">删除</a>
                    </li>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>

<a style="position:absolute;left:1320px;top:2250px;font-size:20px;" href="${pageContext.request.contextPath}/insertbook">新增图书</a>
</body>
</html>
