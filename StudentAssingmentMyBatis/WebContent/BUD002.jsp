<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Register</title>
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
				<div class="search_form">
					<h3>Student Register</h3>
					<label id="errormsg"> ${err} </label> <label style="color: blue;">${msg}</label>
					<br />
					<br />
					<br />
					<form action="StudentRegisterServlet" method="post">
						<table class="tableForm">
							<tr>
								<td class="tblSingleLabel">Student No *</td>
								<td class="tblSingleInput"><input type="text" name="id"
									class="txtlong" value="${bean.studentId}" required/></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Student Name *</td>
								<td class="tblSingleInput"><input type="text" name="name"
									class="txtlong" value="${bean.studentName}" required/></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Class Name *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="normal_sel" name="className" required>
										<option></option>
										<c:forEach var="list" items="${applicationScope.classlist}">
											<option
												<c:if test="${bean.className==list.className}">selected</c:if>>${list.className}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Registered Date *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="short_sel" name="year">
										<option>Year</option>
										<c:forEach var="i" begin="2020" end="2030">
											<option
												<c:if test="${bean.year!='Year' and bean.year==i}">selected</c:if>>${i}</option>
										</c:forEach>

								</select> <select id="expenseType" class="short_sel" name="month">
										<option>Month</option>
										<c:forEach var="i" begin="1" end="12">
											<option
												
												<c:if test="${bean.month!='Month' and bean.month==i}">selected</c:if>>
												<fmt:formatNumber value="${ i}" type="number" minIntegerDigits="2"/>
												</option>
										</c:forEach>
								</select> <select id="expenseType" class="short_sel" name="day">
										<option>Day</option>
										<c:forEach var="i" begin="1" end="31">
											<option
												<c:if test="${bean.day!='Day' and bean.day==i}">selected</c:if>>
												<fmt:formatNumber value="${ i}" type="number" minIntegerDigits="2"/>
												
												</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Status *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="normal_sel" name="status" required>
										<option></option>
										<option
											<c:if test="${bean.status=='Attending'}">selected</c:if>>Attending</option>
										<option <c:if test="${bean.status=='Passed'}">selected</c:if>>Passed</option>
										<option <c:if test="${bean.status=='Failed'}">selected</c:if>>Failed</option>
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