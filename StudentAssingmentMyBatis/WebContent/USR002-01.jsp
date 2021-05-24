<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Update</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="javascript/general.js"></script>
<script type="text/javascript" src="javascript/accordion-menu.js"></script>
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

				<form name="registerForm" action="UserUpdateServlet" method="post">
					<input type="hidden" name="userId" value="${bean[0].userId}" />
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel">User ID *</td>
							<td class="tblSingleInput">${bean[0].userId}</td>

						</tr>
						<tr>
							<td class="tblSingleLabel">User Name</td>
							<td class="tblSingleInput"><input type="text"
								class="txtlong_popup" id="txtUserName" name="userName"
								value="${bean[0].userName}" required/></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput"><input type="password"
								class="txtlong_popup" id="txtUserName" name="userPass"  required/></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm Password *</td>
							<td class="tblSingleInput"><input type="password"
								class="txtlong_popup" id="txtUserName" name="userCon" required /></td>
						</tr>
					</table>
					<br /> <input type="submit" value="Update" class="button" /> <input
						type="button" value="Back" class="button"
						onclick="window.location.replace('USR001.jsp')" />
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