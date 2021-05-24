<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	<%@ include file="showall.jsp" %>
	
	
	<table class="table">
		<thead>
			<tr>
				<th>Label</th>
				<th>with El value</th>
				<th>with jsp:usebean value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Name</td>
				<td>${applicationScope.bean.name }</td>
				<td><jsp:getProperty property="name" name="bean"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${applicationScope.bean.email }</td>
				<td><jsp:getProperty property="email" name="bean"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${applicationScope.bean.password }</td>
				<td><jsp:getProperty property="password" name="bean"/></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td>${applicationScope.bean.gender }</td>
				<td><jsp:getProperty property="gender" name="bean"/></td>
			</tr>
			
			<tr>
				<td>Current Attending Class</td>
				<td>${applicationScope.bean.course }</td>
				<td><jsp:getProperty property="course" name="bean"/></td>
			</tr>
			
			<tr>
				<td>Education</td>
				<td>${applicationScope.bean.education }</td>
				<td><jsp:getProperty property="education" name="bean"/></td>
			</tr>
			
			<tr>
				<td>
					
				</td>
				<td><jsp:getProperty property="photo" name="bean"/></td>
				
			</tr>
		</tbody>
	</table>
	
	
	
	
	
	
</body>
</html>