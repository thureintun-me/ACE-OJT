

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
		xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Update</title>

<link th:href="@{/resources/stylesheets/container.css}" rel="stylesheet"/>
	<link th:href="@{/resources/stylesheets/base.css}"
		rel="stylesheet"/>
	<script type="text/javascript"
		th:src="@{/resources/javascript/general.js}"></script>

	<script type="text/javascript"
		th:src="@{/resources/javascript/accordion-menu.js}"></script>
		
<script type="text/javascript">
	window.onload = function() {
		menu();

	}
</script>
</head>
<body class="main_body">

	
	<header th:insert="header.html :: header"> </header>
	
	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<h3>User Update</h3>
				<label id="errormsg">  </label> <label th:text="${msg}" style="color: blue;"></label>
				<br />
				<br />
				<br />

				<form name="registerForm" action="/updateUser" method="post" th:object="${user}">
					
					<table class="tableForm">
						
					
						<tr>
							<td class="tblSingleLabel">User ID *</td>
							<td class="tblSingleInput"><input type="text" id="txtUserId"
								class="txt_popup" th:field="*{userId}" th:readonly="true"  />
								
								</td>
								
						</tr>
						<tr>
						<td class="tblSingleLabel">User Name</td>
							<td class="tblSingleInput">
							<input type="text" class="txtlong_popup" id="txtUserName" th:field="*{userName}"/>
							<label th:if="${#fields.hasErrors('userName')}" th:errors="*{userName}"
					style="color: red;">Error</label>
							</td>
								 
						</tr>
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput"><input type="password"
								class="txtlong_popup" id="txtUserName" th:field="*{password}"  />
								<label th:if="${#fields.hasErrors('password')}" th:errors="*{password}"
					style="color: red;">Error</label>
								</td>
								
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm Password *</td>
							<td class="tblSingleInput"><input type="password"
								class="txtlong_popup" id="txtUserName" th:field="*{confirmPass}"/>
								<label th:if="${#fields.hasErrors('confirmPass')}" th:errors="*{confirmPass}"
					style="color: red;">Error</label>
								</td>
								
						</tr>
					</table>
					<br /> <input type="submit" value="Update" class="button" /> <input
						type="button" value="Back" class="button"
						onclick="window.location.replace('/usermanagement')" />
				</form>

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