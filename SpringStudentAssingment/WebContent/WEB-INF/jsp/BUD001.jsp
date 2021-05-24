<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD001)Student Search</title>
<link href="<c:url value="static/stylesheets/container.css" />"
	rel="stylesheet">
	<link href="<c:url value="static/stylesheets/base.css" />"
		rel="stylesheet">
	<script type="text/javascript"
		src="<c:url value="/static/javascript/general.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/static/javascript/accordion-menu.js" />"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();

	}

	function resetForm() {
		document.getElementById('message').innerHTML = "Message";
		document.getElementById('list').style.display = "none";
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
					<h3>Student Search Page</h3>
					<form:form action="/SpringStudentAssingment/studentSearchResult" modelAttribute="stuBean" method="get">
						<table class="tableForm">
							<tr>
								<td class="tblLabel">Student No.</td>
								<td class="tblInputShort"><form:input type="text" path="studentId"
									class="txt" /></td>
								<td class="tblLabel">Student Name</td>
								<td class="tblInputShort"><form:input type="text" path="studentName"
									class="txt" /></td>
								<tr />
								<tr>
									<td class="tblLabel">Class Name</td>
									<td class="tblInputNormal" colspan="3"><input type="text"
										id="companyName" name="className" class="txtlong" /></td>
								</tr>
						</table>
						<br /> <input type="submit" value="Search" class="button" /> <input
							type="button" value="Reset" onClick="resetForm()" class="button" />
						<br /> <br />
						<div id="errormsg">
							<label id="message">${err}</label>
						</div>
						<label id="message">${msg}</label>
						<label style="color: blue;"><%= request.getParameter("msg") %></label>
					</form:form>
					<div id="list">
						<form:form name="listForm">
							<Br /> <Br /> <br />
							<table class="resultTable">
								<c:if test="${stulist!=null}">
									<tr class="tblHeader">
										<th width="5%">No</th>
										<th width="10%">Student No</th>
										<th width="25%">Student Name</th>
										<th width="40%">Class Name</th>
										<th width="10%">Registered Date</th>
										<th width="10%">Status</th>
									</tr>
								</c:if>
								<c:forEach var="list" items="${stulist}" varStatus="a">
									<tr>
										<td>${a.count}</td>
										<td>${list.studentId}</td>
										<td><a
											href="/SpringStudentAssingment/setupUpdateStudent/${list.studentName}">${list.studentName}
										</a></td>
										<td>${list.className}</td>
										<td>${list.registerDate}</td>
										<td>${list.status}</td>
									</tr>
								</c:forEach>
							</table>
							<br />

						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>