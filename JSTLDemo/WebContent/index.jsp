<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import var="data" url="header.html"></c:import>	
	<c:out value="${'Welcome' }" />
	<c:out value="${data }"></c:out>
	<c:set var="name" scope="session" value="Ace"></c:set>
	<c:out value="${name }"></c:out>
	<c:set var="income" scope="session" value="${4000*4 }"></c:set>
	<p>Before remove value is : <c:out value="${income }"></c:out></p>
	<c:remove var="income"/>
	<p>After remove value : <c:out value="${income }"></c:out></p>
	
	<c:set var="income" scope="session" value="${4000*4 }"></c:set>
	<c:if test="${income> 8000}">
		<p>My income is <c:out value="${income }"></c:out></p>
	</c:if>
	
	<c:catch var="exception">
		<% int x = 2/0; %>
	</c:catch>
	<c:if test="${exception != null }">
		<p> Exception :<c:out value="${exception}"></c:out> 
		There is an exception : <c:out value="${exception.message}"></c:out> </p>
	</c:if>
	
	<c:set var="income" scope="session" value="${4000*4 }"></c:set>
	<p>Your income is <c:out value="${income }"></c:out></p>
	<c:choose>
		<c:when test="${income <= 1000 }">
			Income is not good
		</c:when>
		
		<c:when test="${income > 10000 }">
			Income is very good
		</c:when>
		
		<c:otherwise>
			Income is undetermined
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="3">
		Item : <c:out value="${i }"></c:out>
	
	</c:forEach>
	
	<c:forTokens items="Thurein_tun_gg_guys" delims="_" var="name">
		<c:out value="${name }"></c:out>
	</c:forTokens>
</body>
</html>