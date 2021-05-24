
<div id="header">
	<div id="title">
		<a href="M00001.jsp">Student Registration Assignment</a>
	</div>
	<div id="menuLoginTime">
		<table>
			<tr>
				<td>User</td>
				<td>: ${sessionScope.sesUser.userId} ${sessionScope.sesUser.userName}</td>
			</tr>
			<tr>
				<td>Current Date</td>
				<td>:<%=new java.util.Date()%></td>
			</tr>
		</table>
	</div>
	<form action="LoginServlet">
		<input id="btn_logout" class="button" type="submit" value="Logout">
	</form>
</div>
