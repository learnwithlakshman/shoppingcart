<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
	<a class="navbar-brand" href="#"> <img
		src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
		width="30" height="30" class="d-inline-block align-top" alt="">
		Bootstrap
	</a>
	
	
	<div class="dropdown mr-5">
	
		<c:if  test="${cartitems.size()>0}">
			<a class="btn btn-primary" href='viewcart.jsp'>ViewCart (${cartitems.size()})</a>
		</c:if>
		<button class="btn btn-secondary dropdown-toggle" type="button"
			id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false">Settings</button>
		
		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<a class="dropdown-item" href="profile">${user.username}</a>
			<a class="dropdown-item" href="logout">Logout</a> 
		</div>
	</div>
</nav>