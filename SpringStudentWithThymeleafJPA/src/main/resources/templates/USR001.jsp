
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search</title>
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

	<header th:insert="header.html :: header"> </header>
	

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>User Search</h3>
					<form action="/userSearch" th:object="${uSearch}" method="post">
						<table class="tableForm">
							<tr>
								<td class="tblLabel"><label>User ID</label></td>
								<td class="tblInputNormal"><input type="text"
									id="txtUserId" class="txt" th:field="*{userId}"  /></td>

								<td class="tblLabel">User Name</td>
								<td class="tblInputNormal"><input type="text"
									id="txtUserName" class="txt" th:field="*{userName}"  /></td>

							</tr>
						</table>

						<br /> <input type="submit" value="Search" class="button" />
					</form>
					<a href="/setupAddUser"> <input type="button" value="Add"
						class="button" id="userInsert" />
					</a> <input type="button"  value="Reset" onClick="resetForm()" class="button"/> <br /> <br />
					<div id="errormsg">
						<label id="message" th:text="${err}"></label>
					</div>
					<label  style="color: blue;"></label>
					<label style="color: blue;" th:text="${msg}"></label>
					
				</div>

				<br />
				<br />
				<br />
				 	<div id="list">

					<table class="resultTable">
						
							<tr class="tblHeader" th:if="${userlist!=null}">
								<th width="1%">Delete</th>
								<th width="1%">Update</th>
								<th width="12%">User ID</th>
								<th width="24%">User Name</th>

							</tr>
						
						
							<tr th:each="list:${userlist}">
								<td>
								
								<a th:href="@{userDelete(userId=${list.userId})}"> <input
										type="button" value="delete" class="button" id="userDelete"  />
								</a>
									
								</td>
								<td><a th:href="@{setupUpdateUser(userId=${list.userId})}"> <input
										type="button" value="Update" class="button" id="userUpdate" />
								</a></td>

								<td th:text="${list.userId}"></td>
								<td th:text="${list.userName}"></td>
							</tr>
						
					</table>

				</div>

			</div>
		</div>

	</div>
	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
	
</body>
</html>
