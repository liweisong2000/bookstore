<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" http-equiv="content-type" content="text/html;charset=utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
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
		if(xmlHttpReq!=null){
			var url="FindUserServlet?username="+username;
			xmlHttpReq.open("get",url,true);
			xmlHttpReq.onreadystatechange=disResult;
			xmlHttpReq.send(null);
		}
		else{
			alert(":no!!!!");	
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
			if(xmlHttpReq.status==200||xmlHttp.status==0){
				alert(xmlHttpReq.responseText);
				document.getElementById("disCheckResult")
			}
			else{
				alert("error!");
			}
		}
	}
	function turn(){
		window.location.href="index";
	}
</script>
<body>
	<div class="register">
	<form name="form1" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
		<table width="100%" border="0" align="center" >
			<tr>
				<th style="font-size:40px;text-align:center;" height="66" colspan="3" scope="col">注册</th>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
							名字:
					</div>
				</th>
				<td width="46%" >
<input name="username" type="text" onblur="getBackInfo()" id="username" style="width:534px;height:34px;">
					<span id="disCheckResult" style="color:red;"></span>
				</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th   scope="row">
					<div align="right">
						密码:
					</div>
				</th>
			<td>
<input name="pwd" type="password" onblur="getBack()" id="pwd" style="width:534px;height:34px;">
					<span id="disCheckResult2" style="color:red;"></span>
			</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th  scope="row">
					<div align="right">
						确认密码:<!--摆设的，暂时没用-->
					</div>
				</th>
			<td>
<input type="password" name="pwd1" style="width:534px;height:34px;">	
			</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th   scope="row">
					<div align="right">
							邮箱:
					</div>
				</th>
				
				<td>
<input name="email" type="text" style="width:534px;height:34px;">
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
					<th   scope="row">
						<div align="right">
								地址:
						</div>
					</th>
					<td>
<input name="address" type="text" style="width:534px;height:34px;">
					</td>
			</tr>
				
			<tr bgcolor="#FFFFFF">
					<th   scope="row">
						<div align="right">
								邮编:
						</div>
					</th>
					<td>
<input name="postcode" type="text" style="width:534px;height:34px;">
					</td>
			</tr>
				
			<tr bgcolor="#FFFFFF">
					<th  scope="row"></th>
					<td>
						<input class="reg" type="submit" value="注册">
						<input class="bac" type="button" onclick="turn()" value="返回">
					</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>