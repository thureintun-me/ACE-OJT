<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<br>
	
		<div style="color: red;">${error}</div>
		<form:form action="/BookManagementMyBatis/addbook" method="post" modelAttribute="bean">
			<table>
				<tr>
					<td>Book Code</td>
					<td><form:input type="text" path="bookCode"></form:input></td>
					<td><form:errors path="bookCode" style="color:red"></form:errors></td>
				</tr>
				<tr>
					<td>Book Title</td>
					<td><form:input type="text" path="bookTitle"></form:input></td>
					<td><form:errors path="bookTitle" style="color:red"></form:errors></td>
				</tr>
				<tr>
					<td>Book Author</td>
					<td><form:input type="text"  path="bookAuthor"></form:input>
					<td><form:errors path="bookAuthor" style="color:red"></form:errors></td>
					<tr>
					<td>Book Price</td>
					<td><form:input type="text" path="bookPrice"></form:input></td>
					<td><form:errors path="bookPrice" style="color:red"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="add"></td>
				</tr>
			</table>
		</form:form>
	

</body>
</html>