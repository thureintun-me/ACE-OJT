<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<td>${sessionScope.myBean.name}</td>
				<td><jsp:getProperty property="name" name="myBean"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${sessionScope.myBean.email}</td>
				<td><jsp:getProperty property="email" name="myBean"/></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td>${sessionScope.myBean.gender}</td>
				<td><jsp:getProperty property="gender" name="myBean"/></td>
			</tr>
			
			
		</tbody>
	</table>
</body>
</html>