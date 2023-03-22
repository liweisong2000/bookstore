<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增图书</title>
<link rel="stylesheet" type="text/css" href="css/insertbook.css"> 
</head>
<script>
	function turn(){
		window.location.href="FindAllBookServlet";
	}
</script>
<body>
	<div class="insert">
	<form name="form1" action="${pageContext.request.contextPath}/InsertBookServlet" method="post">
		<table width="100%" border="0" align="center" >
			<tr>
				<th style="font-size:40px;text-align:center;" height="66" colspan="3" scope="col">新增</th>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
							书名:
					</div>
				</th>
				<td style="paddint-top:20px;padding-left:0px;"width="46%" >
					<input name="bookname" type="text" id="bookname" style="width:534px;height:34px;">
				</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
						作者:
					</div>
				</th>
			<td>
				<input name="writer" type="text" id="writer" style="width:534px;height:34px;">
			</td>
			</tr>
			
			<tr bgcolor="#FFFFFF">
				<th scope="row">
					<div align="right">
						出版社:
					</div>
				</th>
				
				<td>
					<input name="publisher" type="text" style="width:534px;height:34px;">
				</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
								编号:
						</div>
					</th>
					<td>
						<input name="isbn" type="text" style="width:534px;height:34px;">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							价格:
						</div>
					</th>
					<td>
						<input name="price" type="text" style="width:534px;height:34px;">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							库存:
						</div>
					</th>
					<td>
						<input name="remaining" type="text" style="width:534px;height:34px;">
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<th scope="row">
						<div align="right">
							介绍:
						</div>
					</th>
					<td>
						<textarea name="intro"rows="5" cols="72"></textarea>
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