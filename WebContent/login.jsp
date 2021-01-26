<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<div class="row">
			
			
			<div class="col-md-6 offset-md-3">
				<div class="text-danger">${errorMessage}</div>
				<form action="login" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="email"
							 placeholder="Enter email" name="email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="password"
							placeholder="Password" name="password">
					</div>
					
					<button type="submit" class="btn btn-primary mr-3">Login</button><a href="register.jsp">Register</a>
				</form>

			</div>

		</div>

	</div>

</body>
</html>