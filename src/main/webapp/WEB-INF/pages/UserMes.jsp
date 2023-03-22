<%--
  Created by IntelliJ IDEA.
  User: 宋轹蔚
  Date: 2022/5/26
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html;charset=utf-8">
    <title>个人资料</title>
    <link rel="stylesheet" type="text/css" href="css/UserMes.css">
</head>
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
        var username=document.getElementById("username").value;
        if(username.trim().length==0){
            document.getElementById("disCheckResult").innerHTML="用户名不能为空!";
            document.getElementById("username").focus();
            return false;
        }
        else{
            return true;
        }
    }

    function getBack(){
        createRequest();
        var password=document.getElementById("pwd").value;
        if(password.trim().length==0){
            document.getElementById("disCheckResult2").innerHTML="密码不能为空!";
            document.getElementById("pwd").focus();
            return false;
        }
        else{
            return true;
        }
    }

    function disResult(){
        if(xmlHttpReq.readyState==4){
            if(xmlHttpReq.status==200){
                alert(xmlHttpReq.responseText);
                document.getElementById("disCheckResult")
            }
            else{
                alert("error!");
            }
        }
    }

    function click1(){
        window.location='http://localhost:8080/bookstore/FindAllUsersServlet'
    }

</script>
<body>
<div class="User">
    <c:set var="UserMes" scope="session" value="{Usermes}"/>
    <form name="form1" action="${pageContext.request.contextPath}/UpdateUserServlet?id=${UserMes.id}" method="post">
        <table width="100%" border="0" align="center">
            <tr>
                <th style="font-size:40px;text-align:center;" height="66" colspan="3" scope="col">个人信息</th>
            </tr>

            <tr bgcolor="#FFFFFF">
                <th width="15%" height="66" scope="row">
                    <div align="right">
                        名字:
                    </div>
                </th>
                <td style="paddint-top:20px;padding-left:0px;"width="46%" >
                    <input name="username" type="text" onblur="getBackInfo()" id="username" style="width:534px;height:34px;" value="${UserMes.username}">
                    <span id=disCheckResult style="color:red"></span>
                </td>
            </tr>

            <tr bgcolor="#FFFFFF">
                <th width="15%" height="66" scope="row">
                    <div align="right">
                        密码:
                    </div>
                </th>
                <td>
                    <input name="pwd" type="text" onblur="getBack()" id="pwd" value="${UserMes.pwd}" style="width:534px;height:34px;">
                    <span id="disCheckResult2" style="color:red;position:absolute;top:244px;"></span>
                </td>
            </tr>

            <tr bgcolor="#FFFFFF">
                <th width="15%" height="66" scope="row">
                    <div align="right">
                        邮箱:
                    </div>
                </th>

                <td>
                    <input name="email" type="text" value="${UserMes.email}" style="width:534px;height:34px;">
                </td>
            </tr>
            <tr bgcolor="#FFFFFF">
                <th width="15%" height="66" scope="row">
                    <div align="right">
                        地址:
                    </div>
                </th>
                <td>
                    <input name="address" type="text" value="${UserMes.address}" style="width:534px;height:34px;">
                </td>
            </tr>

            <tr bgcolor="#FFFFFF">
                <th width="15%" height="66" scope="row">
                    <div align="right">
                        邮编:
                    </div>
                </th>
                <td>
                    <input name="postcode" type="text" value="${UserMes.postcode}" style="width:534px;height:34px;">
                </td>
            </tr>

            <tr bgcolor="#FFFFFF">

                <td>
                    <input class="per" type="submit" value="提交">
                    <input type="button" class="bac" onclick="click1()" value="返回">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
