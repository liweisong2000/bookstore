<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <head>
   <meta charset="utf-8">
	<title>详细信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/details.css">
   </head>
   
  <html>
  	<div class="intro">
  	<c:set var="BookDet" scope="session" value="${BookDet}"/>
	<img class="pic" src="image/${BookDet.bookname}.jpg" alt="no picture"/>
	
	<ul>
		<li>书名：${BookDet.bookname}</li>
		<li>出版社：${BookDet.publisher}</li>
		<li>价格：${BookDet.price}</li>
		<li>介绍：${BookDet.intro}</li>
		<a href="${pageContext.request.contextPath}/AddToCartServlet?bookid=${BookDet.id}&way=details">加入购物车</a>
	</ul>	
	</div>

</html>

