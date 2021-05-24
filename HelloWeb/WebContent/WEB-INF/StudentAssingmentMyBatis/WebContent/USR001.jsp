<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="javascript/general.js"></script>
<script type="text/javascript" src="javascript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	}
	function checkDelete() {
		var c = confirm("Are you sure you want to delete!");
		if (c) {
			document.getElementById("deleteuser").submit();
		}

	}
	
	function resetForm()
	{
		document.getElementById('message').innerHTML = "Message";
		document.getElementById('list').style.display="none";
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
				<div class="search_form">
					<h3>User Search</h3>
					<form action="UserSearchServlet">
						<table class="tableForm">
							<tr>
								<td class="tblLabel"><label>User ID</label></td>
								<td class="tblInputNormal"><input type="text"
									id="txtUserId" class="txt" name="userId"  /></td>

								<td class="tblLabel">User Name</td>
								<td class="tblInputNormal"><input type="text"
									id="txtUserName" class="txt" name="userName"  /></td>

							</tr>
						</table>

						<br /> <input type="submit" value="Search" class="button" />
					</form>
					<a href="USR002.jsp"> <input type="button" value="Add"
						class="button" id="userInsert" />
					</a> <input type="button"  value="Reset" onClick="resetForm()" class="button"/> <br /> <br />
					<div id="errormsg">
						<label id="message">${err}</label>
					</div>
					<label style="color: blue;">${msg}</label>
				</div>

				<br />
				<br />
				<br />
				<div id="list">

					<table class="resultTable">
						<c:if test="${userlist!=null}">
							<tr class="tblHeader">
								<th width="1%">Delete</th>
								<th width="1%">Update</th>
								<th width="12%">User ID</th>
								<th width="24%">User Name</th>

							</tr>
						</c:if>
						<c:forEach items="${userlist}" var="list">
							<tr>
								<td>
								
								<a href="UserDeleteServlet?id=${list.userId}"> <input
										type="button" value="delete" class="button" id="userDelete" onclick="checkDelete()" />
								</a>
									
								</td>
								<td><a href="UserUpdateServlet?id=${list.userId}"> <input
										type="button" value="Update" class="button" id="userUpdate" />
								</a></td>

								<td>${list.userId}</td>
								<td>${list.userName}</td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>

	</div>
	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
	</div>
</body>
</html>