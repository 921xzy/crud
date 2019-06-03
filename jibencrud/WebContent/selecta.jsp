<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="model.UserDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String course=request.getParameter("course");
	//System.out.print(course);
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	//User users=new User();
	List<User> users=userDaoImpl.loadspell(course);
	for(User user1:users)
	{
%>
<table>
		<tr>
			<td>教师</td>
			<td><input type="text" name="teacher" value="<%=user1.getTeacher()%>"></td>
		</tr>
	
		<tr>
			<td>上课地点</td>
			<td><input type="text" name="address" value=<%=user1.getAddress()%>></td>
		</tr>
	
		<tr>
			<td>课程名称</td>
			<td><input type="text" name="course" value=<%=user1.getCourse()%>></td>
		</tr>
	</table>
	<%} %>
</body>
</html>