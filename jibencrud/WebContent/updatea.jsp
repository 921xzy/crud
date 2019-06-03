<%@page import="model.UserDaoImpl"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%//接收从客户端传递过来的参数
	request.setCharacterEncoding("UTF-8");
	String teacher=request.getParameter("teacher");
	String address=request.getParameter("address");
	String course=request.getParameter("course");
	int id=Integer.parseInt(request.getParameter("id"));
	
	
	
	
	
	//创建数组，存取接收到的值
	User user=new User();
	user.setTeacher(teacher);
	user.setAddress(address);
	user.setCourse(course);
	//user.setId(id);
	
	//调用增加的数据库函数
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	try{
		userDaoImpl.updatesing(user, id);
	}catch(Exception e){
		
	}
	response.sendRedirect("index.jsp"); 
	%>
</body>
</html>