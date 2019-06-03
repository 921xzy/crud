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
	int id=Integer.parseInt(request.getParameter("id"));
	//System.out.print(id);
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	
	%>
	<form action="updatea.jsp" method="post"> 
	<table>
		<tr>
			<td>教师</td>
			<td><input type="text" size="20" name="teacher"></td>
		</tr>
		<tr>
			<td>上课地点</td>
			<td><input type="text" size="20" name="address"></td>
		</tr>
		<tr>
			<td>课程名称</td>
			<td><input type="text" size="20" name="course"></td>
		</tr>
		<tr>
			<td>id</td>
			<td><input type="text" size="20" name="id" value=<%=id%>></td>
		</tr>
	</table>
	<input type="submit" value="保存">&nbsp<input type="reset" value="重置">
	</form>
</body>
</html>