
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD003)Class Register</title>
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
				<h3>Class Register</h3>
				<label th:text="${err}" id="errormsg">  </label> <label th:text="${msg}" style="color: blue;"></label>
				<br />
				<br />
				<br />

				<form name="registerForm" action="/addClass"
					method="post" th:object="${classBean}" >
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel">Class ID *</td>
							<td class="tblSingleInput"><input type="text" id="txtUserId"
								class="txt_popup"  th:field="*{classId}" />
								<label style="color:red" th:if="${#fields.hasErrors('classId')}" th:errors="*{classId}"></label>
								</td>
								
						</tr>
						<tr>
							<td class="tblSingleLabel">Class Name *</td>
							<td class="tblSingleInput"><input type="text"
								class="txtlong_popup" id="txtUserName" 
								th:field="*{className}" />
								<label style="color:red" th:if="${#fields.hasErrors('className')}" th:errors="*{className}"></label>
								</td>
								
						</tr>

					</table>
					<br /> <input type="submit" value="Register" class="button" />
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
