<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String dbname = application.getInitParameter("dbname");
		String username = application.getInitParameter("username");
		String pass = application.getInitParameter("password");
	%>
	<%=
		dbname + " " + username + " " + pass 
	%>
</body>
</html>