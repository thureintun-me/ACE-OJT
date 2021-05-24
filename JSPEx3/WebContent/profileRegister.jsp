<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
		<h3>Registration</h3>
		<form action="RegisterServlet" method="post">
			<div class="form-group row">
				<label for="email" class="col-md-2 col-form-label">Email:</label>
				<div class="col-md-4"><input type="email" name="email" id="email" class="form-control" /></div>
			</div>
			
			<div class="form-group row">
				<label for="password" class="col-md-2 col-form-label">Password:</label>
				<div class="col-md-4"><input type="password" name="password" id="password" class="form-control" /></div>
			</div>
			
			<div class="form-group row">
				<label for="confirmPass" class="col-md-2 col-form-label">Confirm Password:</label>
				<div class="col-md-4"><input type="password" name="confirmPass" id="confirmPass" class="form-control" /></div>
			</div>
			
			<div class="form-group row">
				<label for="name" class="col-md-2 col-form-label">Name:</label>
				<div class="col-md-4"><input type="text" name="name" id="name" class="form-control" /></div>
			</div>
			
			<div class="form-group row">
				<label for="gender" class="col-md-2 col-form-label">Gender:</label>
				<div class="col-md-4">
					<select name="gender" id="">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="course" class="col-md-2 col-form-label">Course:</label>
				<div class="col-md-2">
					<select name="course" id="">
						<option value="Java">Java</option>
						<option value="PHP">PHP</option>
						<option value="Android">Android</option>
						<option value="ASP.Net">ASP.Net</option>
					</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="education" class="col-md-2 col-form-label">Education:</label>
				<div class="col-md-2">
					<select name="education" id="">
						<option value="Master in CS">Master in CS</option>
						<option value="Diploma in IT">Diploma in IT</option>
						<option value="BE(IT)">BE(IT)</option>
						
					</select>
				</div>
			</div>
			<div class="form-group row">
   				 <label for="photo" class="col-md-2 col-form-label">Photo:</label>
   				 <div class="col-md-6">
   				 	<input type="file" class="form-control-file" id="photo" name="photo">
   				 </div>
   				 
 		   </div>
 		   
 		   			<button type="submit" class="btn btn-primary my-1">Register</button>
 		   		 
 		  
 		  
		</form>
</body>
</html>