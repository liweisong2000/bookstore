<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*,java.sql.*,java.io.*"
	pageEncoding="utf-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>详细订购信息</title>
<link rel="stylesheet" type="text/css" href="css/orderDetails.css"> 
</head>
<body>
	<div class="orderde">
	<c:set var="Order" scope="session" value="${OrderDetail}"/>
	<img class="pic" src="image/${Order.bookname}.jpg" alt="no picture" />
	<ul>
		<li >订单号：${Order.id }(数量${Order.number})</li>
		<li >地址：${Order.address }</li>
		<li >邮编：${Order.postcode }</li>
		<li >日期：${Order.orderdate }</li>
		<li >状态：已付款</li>
	</ul>	
	</div>

</body>
</html>