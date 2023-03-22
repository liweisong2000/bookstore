<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/shopcart.css">
<script type="text/javascript">
	function onsub(element){
		let id=element.form.id;
		let bookname=document.getElementById(id)[0].value;
		let address=document.getElementById(id)[1].value;
		let postcode=document.getElementById(id)[2].value;
		let number=document.getElementById(id)[4].value;
window.location.href="CheckOutServlet?id="+id+"&bookname="+bookname+"&address="+address+"&postcode="+postcode+"&booknumber="+number;
	}
	
	function ondelete(element){
		let id=element.form.id;
		window.location.href="DeleteCartServlet?Deleteid="+id;
	}
		
	function subtract1(element){
		let id=element.form.id;
		let number=document.getElementById(id)[4].value;
		document.getElementById(id)[4].value=number-1;
	}
	
	function add1(element){
		let id=element.form.id;
		let number=document.getElementById(id)[4].value;
		let num=parseInt(number,10);
		let n=num+1;
		document.getElementById(id)[4].value=n;
	}
</script>

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
	
<table class="shopcar" width="55%" border="1" align="center">
	<c:forEach items="${ShopCart}" var="ShopCart">
	<tr>
	<form id="${ShopCart.id}" action="${pageContext.request.contextPath}/CheckOutServlet" method="post" onsubmit="onsubmit()">
			<th width="20%" rowspan="1"><img src="image/${ShopCart.bookname}.jpg" alt=""/></th>
			<td width="65%">
					<input type="text" hidden="hidden" value="${ShopCart.bookname}">
					<ul id="100">	
					
						<li name="bookname">书名：${ShopCart.bookname}</li>
						<li>地址：<input type="text" style="width:420px;height:20px;" name="address"></li>
						<li>邮编：<input type="text" style="width:420px;height:20px;" name="postcode"></li>
			<li style="margin-left:390px;">
			<input class="sub" onclick="subtract1(this)" type="button" value="-">
 			<input id="number" name="goodnum" type="text" value="${ShopCart.number}" style="width:25px;">
			<input class="add" onclick="add1(this)" type="button" value="+">
			</li>
			<li>
			<input style="margin-left:359px;" class="delete" type="button" onclick="ondelete(this)" value="删除">
			<input style="margin-left:15px;" class="checkout" type="button" onclick="onsub(this)" value="结账">
			</li>
			</ul>
			</td>
	</form>
	</tr>
	</c:forEach>
</table>	
</body>
</html>