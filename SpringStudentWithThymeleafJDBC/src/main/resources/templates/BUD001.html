
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD001)Student Search</title>
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

	function resetForm() {
		document.getElementById('message').innerHTML = "Message";
		document.getElementById('list').style.display = "none";
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
					<h3>Student Search Page</h3>
					<form action="/studentSearchResult" th:object="${stuBean}" method="get">
						<table class="tableForm">
							<tr>
								<td class="tblLabel">Student No.</td>
								<td class="tblInputShort"><input type="text" th:field="*{studentId}"
									class="txt" /></td>
								<td class="tblLabel">Student Name</td>
								<td class="tblInputShort"><input type="text" th:field="*{studentName}"
									class="txt" /></td>
								</tr >
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
							<label id="message" th:text="${err}"></label>
						</div>
						<label id="message"></label>
						<label style="color: blue;" th:text="${msg}"></label>
					</form>
					<div id="list">
						<form name="listForm">
							<Br /> <Br /> <br />
							<table class="resultTable" >
								
									<tr class="tblHeader" th:if="${stulist!=null}">
										<th width="5%">No</th>
										<th width="10%">Student No</th>
										<th width="25%">Student Name</th>
										<th width="40%">Class Name</th>
										<th width="10%">Registered Date</th>
										<th width="10%">Status</th>
									</tr>
								
								
									<tr th:each="list:${stulist}">
										<td th:text="${listStat.index+1}"></td>
										<td th:text="${list.studentId}" th:value="${list.studentId}"></td>
										<td >
										<a
											th:href="@{setupUpdateStudent(studentName=${list.studentName})}" th:text="${list.studentName}" ></a>
										</td>
										<td th:text="${list.className}"></td>
										<td th:text="${list.registerDate}"></td>
										<td th:text="${list.status}"></td>
									</tr>
								
							</table>
							<br />

						</form>
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