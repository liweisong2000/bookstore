<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改图书信息</title>
<link rel="stylesheet" type="text/css" href="css/ModifyBook.css"> 
<script type="text/javascript">
	function turn(){
		window.location='http://localhost:8080/bookstore/bookmanage'
}
</script>
</head>
<body>
	<div class="modify">
	<c:set var="ModBook"  scope="session"  value="${ModBook}" />
	<form name="form1" action="${pageContext.request.contextPath}/UpdateBookServlet?ModBookid=${ModBook.id}" method="post">
		<table width="100%" border="0" align="center">
			<tr>
				<th style="font-size:40px;text-align:center;" height="66" colspan="3" scope="col">修改</th>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
						书名:
					</div>
				</th>
				<td style="paddint-top:20px;padding-left:0px;"width="46%" >
					<input name="bookname" type="text" id="bookname" style="width:534px;height:34px;" value="${ModBook.bookname}">
				</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
						作者:
					</div>
				</th>
			<td>
				<input name="writer" type="text" style="width:534px;height:34px;" value="${ModBook.writer}">
			</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
						出版社:
					</div>
				</th>
				
				<td><input name="publisher" type="text" style="width:534px;height:34px;" value="${ModBook.publisher}">
				</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							编号:
						</div>
					</th>
					<td>
						<input name="isbn" type="text" style="width:534px;height:34px;" value="${ModBook.isbn}">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							价格:
						</div>
					</th>
					<td>
						<input name="price" type="text" style="width:534px;height:34px;" value="${ModBook.price}">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							库存:
						</div>
					</th>
					<td>
						<input name="remaining" type="text" style="width:534px;height:34px;" value="${ModBook.remaining}">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							日期:
						</div>
					</th>
					<td>
						<input name="date" type="date" style="height:34px;" value="${ModBook.date}">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							介绍:
						</div>
					</th>
					<td>
						<textarea name="intro" rows="5" cols="72">${ModBook.intro}</textarea>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>
						<input class="subb" type="submit" value="提交">
						<input class="bac" type="button" onclick="turn()" value="返回">
					</td>
				</tr>
		</table>
	</form>
	</div>
</body>
</html>