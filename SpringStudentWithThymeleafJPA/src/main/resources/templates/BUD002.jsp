
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Register</title>
<link th:href="@{/resources/stylesheets/container.css}" rel="stylesheet" />
<link th:href="@{/resources/stylesheets/base.css}" rel="stylesheet" />
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
				<div class="search_form">
					<h3>Student Register</h3>
					<div>
						<label id="errormsg" th:text="${err}" style="color: red;">
						</label>
					</div>
					<div></div>

					<label th:text="${msg}" style="color: blue;"></label> <br /> <br />
					<br />
					<form action="/addStudent" method="post" th:object="${bean}">
						<table class="tableForm">
							<tr>
								<td class="tblSingleLabel">Student No *</td>
								<td class="tblSingleInput"><input type="text"
									th:field="*{studentId}" class="txtlong" /> <label
									style="color: red" th:if="${#fields.hasErrors('studentId')}"
									th:errors="*{studentId}"></label></td>

							</tr>
							<tr>
								<td class="tblSingleLabel">Student Name *</td>
								<td class="tblSingleInput"><input type="text"
									th:field="*{studentName}" class="txtlong" /> <label
									style="color: red" th:if="${#fields.hasErrors('studentName')}"
									th:errors="*{studentName}"></label></td>

							</tr>
							<tr>
								<td class="tblSingleLabel">Class Name *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="normal_sel" th:field="*{className}">


										<option
											th:each="list :${#servletContext.getAttribute('clsList')}"
											th:selected="${bean.className==list.className}"
											th:text="${list.className}" th:value="${list.className}">c</option>




								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Registered Date *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="short_sel" th:field="*{year}">
										<option th:value="Year">Year</option>

										<option th:each="i:${#numbers.sequence(2020,2030)}"
											th:selected="${bean.year!='Year' and bean.year==i}"
											th:text="${i}" th:value="${i}">i</option>

								</select> <select id="expenseType" class="short_sel" th:field="*{month}">
										<option th:value="Month">Month</option>


										<option th:each="i:${#numbers.sequence(1,12)}"
											th:text="${#numbers.formatInteger(i,2)}"
											th:selected="${bean.month!='Month' and bean.month==i}"
											th:value="${#numbers.formatInteger(i,2)}">i</option>





								</select> <select id="expenseType" class="short_sel" th:field="*{day}">
										<option th:value="Day">Day</option>

										<option th:each="i:${#numbers.sequence(1,31)}"
											th:text="${#numbers.formatInteger(i,2)}"
											th:selected="${bean.day!='Day' and bean.day==i}"
											th:value="${#numbers.formatInteger(i,2)}">num</option>

								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Status *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="normal_sel" th:field="*{status}">

										<option th:selected="(${bean.status} == 'Attending')"
											th:value="Attending">Attending</option>
										<option th:selected="(${bean.status} == 'Passed')"
											th:value="Passed">Passed</option>
										<option th:selected="(${bean.status} == 'Failed')"
											th:value="Failed">Failed</option>
								</select></td>
							</tr>


						</table>
						<br />
						<div id="btnGroup">
							<input type="submit" value="Register" class="button" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>
