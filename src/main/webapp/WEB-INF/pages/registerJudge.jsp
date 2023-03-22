<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	<% 
		String path=request.getContextPath(); 
		String basePath=request.getScheme()+"://"
				+request.getServerName()+":" +request.getServerPort()+path+"/";
	%>
	
	<% 
		String username=request.getParameter("username");
		String status=(String)request.getAttribute("Status");
		if(status.equals("right")){
			out.println("账号已被注册");
		}
		else {
			out.println("可以注册");
		}
	%>
