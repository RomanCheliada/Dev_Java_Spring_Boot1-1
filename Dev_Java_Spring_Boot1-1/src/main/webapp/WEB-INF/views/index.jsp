<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Easy Trans </title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Easy Trans</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cargos">Cargos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/transporters">Transporters</a>
      </li>
      <sec:authorize access="isAuthenticated()" >
      <li class="nav-item">
        <a class="nav-link" href="/add-order">Add order</a>
      </li>
      </sec:authorize>
      <sec:authorize access="isAnonymous()" >
      <li class="nav-item">
        <a class="nav-link" href="/login">Add order</a>
      </li>
      </sec:authorize>
     
    </ul>
    <sec:authorize access="isAnonymous()">
    <a href="/registration" class="btn btn-outline-info btn-sm">Sign up</a>
    <a>or</a>
    <a href="/login" class="btn btn-outline-info btn-sm">Log in</a>
    </sec:authorize>
     <sec:authorize access="isAuthenticated()">
     <a  style="color: white; margin: 5px;">${message}</a>
     </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    	<form:form >
 			<a href="/admin" style="margin: 5px" class="btn btn-outline-info btn-sm ">Admin</a>
 		</form:form>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    
    	<form:form action="/logout">
 			<button class="btn btn-outline-info btn-sm">Log out</button>
 		</form:form>
    </sec:authorize>
  </div>
  
  
</nav>
<div class="container">
	<div class="row">
		<div class="col-12">
			<h2 class="text-center" style="margin: 15px">Add your order now!</h2>
			<a href="/add-order" style="margin: 15px" class="btn btn-outline-success text-center btn-block btn-lg">Add order</a>
			<sec:authorize access="isAuthenticated()">
			<h2 style="margin: 15px">${message}</h2>
			</sec:authorize>
		</div>
	</div>
</div>

	
	<div class="container">
		<div class="row">
			<div class="col-1">
			
			</div>
			<div class="col-2">
				top 1
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-2">
				top 2
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-2">
				top 3
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-2">
				top 4
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-2">
				top 5
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-1">

			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
				<div class="col-6">
				top 1
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-6">
				top 2
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-4">
				top 3
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-4">
				top 4
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
			<div class="col-4">
				top 5
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Name</h4>
						<p class="card-text">
							<a>Age:</a><br>
							<a>Car:</a><br>
							<a>Rate:</a><br>
						</p>
						<a href="#" class="btn btn-outline-info">Read more</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>