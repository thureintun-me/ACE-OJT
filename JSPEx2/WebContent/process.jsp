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
		String[] subjects =request.getParameterValues("subject");
		
		if(subjects!=null){
			
			out.println("<h4>Your profession is </h4>");
			for(int i=0;i<subjects.length;i++){
				out.println("<p>"+(i+1)+"." + subjects[i] +"</p>" );
			}	
			
			
		}else{
			out.print("<h3 style='color:red;'>Chooose One!!!</h3>");
			
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	
	%>
</body>
</html>