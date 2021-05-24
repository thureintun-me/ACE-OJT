<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="PersonServlet">
	<input type="submit" value="refresh">
</form>
	
	<jsp:useBean id="person" scope="request" class="com.thurein.Person"></jsp:useBean>
	<jsp:useBean id="name" scope="request" class="com.thurein.Name"></jsp:useBean>
	 <jsp:getProperty property="firstName" name="name"/>
	${name.firstName }
	
	
</body>
</html>