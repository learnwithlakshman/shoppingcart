<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	
	
	<div class="container mt-5">

		<div class="row">
			<div class="col-md-8 offset-md-2">

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Title</th>
							<th scope="col">Price</th>
							<th scope="col">Cart</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${books}" var="book">
							<tr>
								<td>${book.id}</td>
								<td>${book.title}</td>
								<td>${book.price}</td>
								<td><a href='addtocart?id=${book.id}'>Add to cart</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	</div>


</body>
</html>