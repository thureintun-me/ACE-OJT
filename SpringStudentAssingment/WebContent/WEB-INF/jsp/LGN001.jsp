<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(LGN001)login</title>
<link href="<c:url value="static/stylesheets/container.css" />"
	rel="stylesheet">
	<link href="<c:url value="static/stylesheets/base.css" />"
		rel="stylesheet">
	
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>

</head>
<body class="main_body" onload="noBack();"
	onpageshow="if (event.persisted) noBack();" onunload="">
	<div id="header">
		<div id="title">
			<u>Student Registration Assignment</u>
		</div>
	</div>

	<div id="container">
		<div id="main_contents">
			<div style="margin-left: 35%">
				<form:form action="/SpringStudentAssingment/login" method="post" name="confirm" modelAttribute="login">
					<br />
					<table class="sortName">
						<tr>
							<td colspan="2" align="center">
								<h3>Login</h3>
							</td>
						</tr>
						<tr align="left">
							<td id="errormsg">${err}</td>
						</tr>

						<tr align="left">
							<td>User ID</td>

							<td><form:input type="text" class="normal_width1" path="userId" /></td>
						</tr>

						<tr align="left">
							<td><br /> Password</td>

							<td><form:input type="password" class="normal_width1"
								path="password" /></td>
						</tr>
						<tr>
							<td colspan="2"><br />
								<table align="center">
									<tr>
										<td><input name="Submit" type="submit" value="Login"
											class="button" /></td>
									</tr>

								</table></td>
						</tr>
					</table>
				</form:form>

			</div>
		</div>
		<!-- end of main contents -->
	</div>
	<!-- end of container -->

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>

</body>
</html>
