<%@page import="java.util.ArrayList"%>
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
	<%UserDaoImpl userDaoImpl=new UserDaoImpl();
	List<User> user=new ArrayList();
	user=userDaoImpl.load();
	for(User user1 : user)
	{
		%>
		<table width="800" border="1" align="center">
				<tr>
				  <td ><input type="text" size="10" value="<%=user1.getTeacher() %>"></td>
				  <td><input type="text" size="10" value="<%=user1.getAddress() %>"></td>
				  <td><input type="text" size="10" value="<%=user1.getCourse()%>"></td>
				 

				
				  <td><a href="update.jsp?id=<%=user1.getId()%>" target='_blank'>修改</a></td>
				</tr>
				</table>
		<%
		
	}
	%>
</body>
</html>