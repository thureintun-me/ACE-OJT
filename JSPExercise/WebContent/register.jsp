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
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String[] course = request.getParameterValues("course");
		
		out.println("<p>" +"Name : " + name + "</p>");
		out.println("<p>" + "DOB : " + dob + "<p>");
		out.println("<p>" + "Gender : " + gender + "<p>");
		
		for(int i=0;i<course.length;i++){
			out.println("<p>" + "Subject " + (i+1)+ " : " + course[i] + "<p>");
			
		}
	
	%>
</body>
</html>