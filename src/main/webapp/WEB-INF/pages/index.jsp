<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0"> 
<title>BookStore</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<script src="js/index.js">
</script>
</head>
<body>
	
	<div class="head"> 
			<img class="pic1" src="${pageContext.request.contextPath}/image/BookStore.png" />
			<img class="pic2" src="${pageContext.request.contextPath}/image/求知书屋.png"   />
	
    		<form class="search" action="#" method="post">
      			<input class="s1"type="text" placeholder="书名/作者" >
      			<img class="searchp" src="${pageContext.request.contextPath}/image/search.png" alt=""/>
      			<input class="sea" type="submit" value="搜索"/>
    		</form>
  		
  			<c:set var="USER" scope="session" value="${username}"/>
  			<c:choose>
  			<c:when test="${not empty USER}">
      			<p style="position:absolute;right:100px;top:28px;font-size:20px;">欢迎光临，尊敬的${USER}客户</p>
    		</c:when>
    		<c:otherwise>
    			<button class="log">
      				<a style="color:white;" href="${pageContext.request.contextPath}/register">注册</a>/
      				<a style="color:white;" href="${pageContext.request.contextPath}/login">登录</a>
    			</button>
    		</c:otherwise>
    		</c:choose>
	</div>
	
	<div class="center">
		<c:set var="power"  scope="session"  value="${power}" />
		
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
	<div class="con">
   		<i class="arrow-l"><img src="${pageContext.request.contextPath}/image/arrow1.png" style="width:50px; height:50px; position:relative;right:9px;top:15px;"/></i>
   		<i class="arrow-r"><img src="${pageContext.request.contextPath}/image/arrow2.png" style="width:50px; height:50px; position:relative;right:2px;top:15px;"/></i>
   	<ul class="d">
   		<li>
			<a href="js/index.js"><img src="${pageContext.request.contextPath}/image/book1.jpeg" alt="" style="width: 1300px;height: 570px;"/></a>
		</li>
		<li class="da">
		<a href="js/index.js"><img src="${pageContext.request.contextPath}/image/book2.jpeg" alt="" style="width: 1300px;height: 570px;"/></a>
		</li>
		<li class="da">
		<a href="js/index.js"><img src="${pageContext.request.contextPath}/image/book3.jpeg" alt="" style="width: 1300px;height: 570px;"/></a>
		</li>
		<ol class="db">
     	<li class="d1"></li>
     	<li class="d2"></li>
     	<li class="d3"></li>
     	</ol>
	</div>
	<strong class="newbook" style="font-size:30px;">新书上架</strong>
	<a style="position:absolute;top:779px;left:1380px;font-size:20px;"href="FindAllBookServlet?way=MoreBook">更多</a>
	<div class="newb">
		<div class="book1">
<a onclick="window.open('BookDetailServlet?bookname=湘行散记', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
			<img src="${pageContext.request.contextPath}/image/湘行散记.jpg" alt="" style="width: 198px;height: 298px;"/>
			<p style="margin-left:10px;">湘行散记</p>
			<p style="margin-left:10px;">沈从文</p>
			<p style="margin-left:10px;">￥30</p>
</a>
		</div>	
		<div class="book2">
<a onclick="window.open('BookDetailServlet?bookname=爱是一场渐行渐远的分离', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
			<img src="${pageContext.request.contextPath}/image/爱是一场渐行渐远的分离.jpg" alt="" style="width: 198px;height: 298px;"/>
			<p style="margin-left:10px;">爱是一场渐行渐远的分离</p>
			<p style="margin-left:10px;">徐志摩</p>
			<p style="margin-left:10px;">￥30</p>
</a>
		</div>
		<div class="book2">
<a onclick="window.open('BookDetailServlet?bookname=三体', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
			<img src="${pageContext.request.contextPath}/image/三体.jpg" alt="" style="width: 198px;height: 298px;"/>
			<p style="margin-left:10px;">三体</p>
			<p style="margin-left:10px;">刘慈欣</p>
			<p style="margin-left:10px;">￥40</p>
</a>
		</div>
		<div class="book2">
<a onclick="window.open('BookDetailServlet?bookname=狂人日记', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
			<img src="${pageContext.request.contextPath}/image/狂人日记.jpg" alt="" style="width: 198px;height: 298px;"/>
			<p style="margin-left:10px;">狂人日记</p>
			<p style="margin-left:10px;">鲁迅</p>
			<p style="margin-left:10px;">￥40</p>
</a>
		</div>
		<div class="book2">
<a onclick="window.open('BookDetailServlet?bookname=呐喊', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
			<img src="${pageContext.request.contextPath}/image/呐喊.jpg" alt="" style="width: 198px;height: 298px;"/>
			<p style="margin-left:10px;">呐喊</p>
			<p style="margin-left:10px;">鲁迅</p>
			<p style="margin-left:10px;">￥27</p>
</a>
		</div>
		<div class="book2">
<a onclick="window.open('BookDetailServlet?bookname=解忧杂货店', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
			<img src="${pageContext.request.contextPath}/image/解忧杂货店.jpg" alt="" style="width: 198px;height: 298px;"/>
			<p style="margin-left:10px;">解忧杂货店</p>
			<p style="margin-left:10px;">东野圭吾</p>
			<p style="margin-left:10px;">￥30</p>	
</a>
		</div>
	</div>

	<strong class="recom" style="font-size:30px;">新书推荐</strong>
	<div class="book3">
	<a onclick="window.open('BookDetailServlet?bookname=Hacking', 'newwindow', 'height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
	<img src="${pageContext.request.contextPath}/image/Hacking.jpg" alt="" style="width:282px;height:427px;margin-top:30px;margin-left:90px;"/>
	</a>
		<ul class="RecomMes">
			<li style="font-size:53px;margin-left:40px;margin-top:70px;">Hacking</li>	
			<li style="font-size:22px;margin-left:40px;margin-top:5px;">Jon Erickson</li>
			<li style="font-size:15px;margin-left:40px;margin-top:10px;">No Starch Press</li>
			<li style="font-size:30px;margin-left:40px;margin-top:45px;">￥130</li>
			<li><img style="margin-left:43px;margin-top:15px;"src="${pageContext.request.contextPath}/image/star1.png"/>
			<img src="${pageContext.request.contextPath}/image/star1.png"/>
			<img src="${pageContext.request.contextPath}/image/star1.png"/>
			<img src="${pageContext.request.contextPath}/image/star1.png"/>
			<img src="${pageContext.request.contextPath}/image/star2.png"/>
			</li>
		</ul>
	</div>
	
</div>

<div>
	<strong class="Order" style="font-size:30px;">订购信息</strong>
	
	<div class="OrderMes">
	<ul>
	<c:forEach items="${BuyMes}" var="BuyMes">
					<li>
					<a class="a1">${BuyMes.bookname}</a>
<a class="a2" onclick="javascript:window.open ('ShowBuyMesServlet?BuyMesid=${BuyMes.id}&Buybookname=${BuyMes.bookname}','newwindow','height=320,width=530,top=240,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');">
${BuyMes.orderdate}</a>
					</li>
					<br/><br/>
	</c:forEach>
	</ul>
	</div>
</div>
</body>
</html>

