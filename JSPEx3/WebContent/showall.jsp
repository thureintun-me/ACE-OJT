<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="myBean" class="com.thurein.ProfileBean" scope="session"></jsp:useBean>
	<jsp:useBean id="bean" class="com.thurein.ProfileBean" scope="application"></jsp:useBean>
	
	<a href="profileHome.jsp">Home</a> |
	<a href="profile.jsp">Profile</a> |
	
	
	<a href="ProfileLogoutServlet">logout</a>
</body>
</html>