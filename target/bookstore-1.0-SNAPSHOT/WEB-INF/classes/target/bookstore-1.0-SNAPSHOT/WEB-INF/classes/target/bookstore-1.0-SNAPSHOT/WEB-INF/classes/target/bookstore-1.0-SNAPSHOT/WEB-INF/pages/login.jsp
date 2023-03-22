<%--
  Created by IntelliJ IDEA.
  User: 宋轹蔚
  Date: 2022/5/10
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录入口</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/login.css">
    <script src="js/index.js">
    </script>
    <script>
        var xmlHttpReq=null;
        function createRequest(){
            if(window.XMLHttpRequest){
                xmlHttpReq=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                xmlHttpReq=new ActiveXOject("Microsft.XMLHTTP");//Microsoft
            }
        }

        function getBackInfo(){
            createRequest();
            var username=document.getElementById("sub").children[2].value;
            if(username.trim().length==0){
                document.getElementById("tip1").innerHTML="名不能为空!";
                document.getElementById("username").focus();
                return false;
            }
            else{
                return true;
            }
        }

        function getBack(){
            createRequest();
            var password=document.getElementById("sub").children[7].value;
            if(password.trim().length==0){
                document.getElementById("tip2").innerHTML="密码不能为空!";
                document.getElementById("password").focus();
                return false;
            }
            else{
                return true;
            }
        }

        function turn(){
            window.location.href="index.jsp";
        }
    </script>
</head>
<body>
<div class="div_01">

</div>
<div class="login">
    <form id="sub"  action="${pageContext.request.contextPath}/loginServlet" method="post">
        <c:set var="result"  scope="request"  value="${result}" />
        <c:if test="${result eq 'wrong'}">
            <p class="p1">您的用户名和密码不匹配</p>
        </c:if>
        <h1 style="font-size:40px;">登录</h1>
        <p class="p2">用户名</p>
        <input style="width:584px;height:46px;margin-top:45px;" type="text" onblur="getBackInfo()" name="username" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入用户名"><br/><br/>
        <span class="tip1" id="tip1" style="color:red"></span>
        <p class="p3">密码</p>
        <input style="width:584px;height:46px;margin-top:43px;" type="password" onblur="getBack()" name="pwd" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入密码"><br/><br/>
        <span class="tip2" id="tip2" style="color:red"></span>
        <input class="log" type="submit" onsubmit="return false" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input class="bac"type="button" onclick="turn()" value="返回"><br>

    </form>
</div>
</body>
</html>
