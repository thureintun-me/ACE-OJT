<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Register</title>
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
					<h3>Student Register</h3>
					<div>
						<label id="errormsg"> ${err}<%= request.getParameter("err") %> </label>
					</div>
					<div>
						<label id="errormsg"> ${msg} </label>
					</div>
					
					 <label style="color: blue;"><%= request.getParameter("msg") %></label>
					<br />
					<br />
					<br />
					<form:form action="/SpringStudentAssingment/addStudent" method="post" modelAttribute="bean">
						<table class="tableForm">
							<tr>
								<td class="tblSingleLabel">Student No *</td>
								<td class="tblSingleInput"><form:input type="text" path="studentId"
									class="txtlong"  /></td>
									<form:errors path="studentId" style="color:red"></form:errors>
							</tr>
							<tr>
								<td class="tblSingleLabel">Student Name *</td>
								<td class="tblSingleInput"><form:input type="text" path="studentName"
									class="txtlong" /></td>
									<form:errors path="studentName" style="color:red"></form:errors>
							</tr>
							<tr>
								<td class="tblSingleLabel">Class Name *</td>
								<td class="tblSingleInput"><form:select id="expenseType"
									class="normal_sel" path="className" >
										<option></option>
										<c:forEach var="list" items="${classlist}">
											<option <c:if test="${bean.className==list.className}">selected</c:if>>${list.className}</option>

										</c:forEach>
								</form:select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Registered Date *</td>
								<td class="tblSingleInput"><form:select id="expenseType"
									class="short_sel" path="year">
										<option>Year</option>
										<c:forEach var="i" begin="2020" end="2030">
											<option
												<c:if test="${bean.year!='Year' and bean.year==i}">selected</c:if>>${i}</option>
										</c:forEach>

								</form:select> <form:select id="expenseType" class="short_sel" path="month">
										<option>Month</option>
										<c:forEach var="i" begin="1" end="12">
											<option
												
												<c:if test="${bean.month!='Month' and bean.month==i}">selected</c:if>>
												<fmt:formatNumber value="${ i}" type="number" minIntegerDigits="2"/>
												</option>
										</c:forEach>
								</form:select> <form:select id="expenseType" class="short_sel" path="day">
										<option>Day</option>
										<c:forEach var="i" begin="1" end="31">
											<option
												<c:if test="${bean.day!='Day' and bean.day==i}">selected</c:if>>
												<fmt:formatNumber value="${ i}" type="number" minIntegerDigits="2"/>
												
												</option>
										</c:forEach>
								</form:select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Status *</td>
								<td class="tblSingleInput"><form:select id="expenseType"
									class="normal_sel" path="status" >
										<option></option>
										<option
											<c:if test="${bean.status=='Attending'}">selected</c:if>>Attending</option>
										<option <c:if test="${bean.status=='Passed'}">selected</c:if>>Passed</option>
										<option <c:if test="${bean.status=='Failed'}">selected</c:if>>Failed</option>
								</form:select></td>
							</tr>


						</table>
						<br />
						<div id="btnGroup">
							<input type="submit" value="Register" class="button" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>
