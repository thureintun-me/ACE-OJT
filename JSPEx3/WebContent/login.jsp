<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	<h3>Login Form</h3>
	<form action="ProfileRegisterServlet" method="post">
	
		<div class="form-group row">
			<label for="email" class="col-form-label col-md-1">Email</label>
			<div class="col-md-4"><input type="text" name="email" id="email" class="form-control" /></div>
		</div>
		
		<div class="form-group row">
			<label for="password" class="col-form-label col-md-1">Password</label>
			<div class="col-md-4"><input type="password" name="password" id="password" class="form-control" /></div>
		</div>
		
		
		<button class="btn btn-outline-primary" type="submit">Login</button>
		<a class="btn btn-outline-primary" href="profileRegister.jsp" role="button">Register</a>
		
		
	</form>
</body>
</html>