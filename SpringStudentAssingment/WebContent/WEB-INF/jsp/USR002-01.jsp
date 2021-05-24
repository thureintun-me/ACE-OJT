<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Update</title>

<link href="<c:url value="/static/stylesheets/container.css" />"
	rel="stylesheet">
	<link href="<c:url value="/static/stylesheets/base.css" />"
		rel="stylesheet">
	<script type="text/javascript"
		src="<c:url value="/static/javascript/general.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/static/javascript/accordion-menu.js" />"></script>
		
<script type="text/javascript">
	window.onload = function() {
		menu();

	}
</script>
</head>
<body class="main_body">

	<jsp:include page="header.jsp" />

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<h3>User Update</h3>
				<label id="errormsg"> ${err} </label> <label style="color: blue;">${msg}</label>
				<br />
				<br />
				<br />

				<form:form name="registerForm" action="/SpringStudentAssingment/updateUser" method="post" modelAttribute="user">
					
					<table class="tableForm">
						<form:input type="hidden" path="userId"/>
					
						<tr>
							<td class="tblSingleLabel">User ID *</td>
							<td class="tblSingleInput">${user.userId}</td>

						</tr>
						<tr>
						<td class="tblSingleLabel">User Name *</td>
							<td class="tblSingleInput"><form:input type="text"
								class="txtlong_popup" id="txtUserName" path="userName"
								 /></td>
								 <form:errors path="userName" style="color:red"></form:errors>
						</tr>
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput"><form:input type="password"
								class="txtlong_popup" id="txtUserName" path="password"  /></td>
								<form:errors path="password" style="color:red"></form:errors>
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm Password *</td>
							<td class="tblSingleInput"><form:input type="password"
								class="txtlong_popup" id="txtUserName" path="confirmPass"  /></td>
								<form:errors path="confirmPass" style="color:red"></form:errors>
						</tr>
					</table>
					<br /> <input type="submit" value="Update" class="button" /> <input
						type="button" value="Back" class="button"
						onclick="window.location.replace('USR001.jsp')" />
				</form:form>

				<br />
				<br />
				<br />
			</div>
		</div>

	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>