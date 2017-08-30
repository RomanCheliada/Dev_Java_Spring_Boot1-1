<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Transporters</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Easy Trans</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="/cargos">Cargos</a>
      </li>
      <li class="nav-item active">
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
				<table class="table table-hover table-inverse">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Max weight</th>
						<th class="text-center">Count</th>
						<th class="text-center">Age</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Brand</th>
						<th class="text-center">Model</th>
						<th class="text-center">Car age</th>
						<th class="text-center">City arrive</th>
						<th class="text-center">Date arrive</th>
						<th class="text-center">Status</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="transporter" items="${transporters}">
						<tr>
							<td>${transporter.name}</td>
							<td>${transporter.rate}</td>
							<td>${transporter.maxWeight}</td>
							<td>${transporter.count}</td>
							<td>${transporter.age}</td>
							<td>${transporter.phone}</td>
							<td>${transporter.brand}</td>
							<td>${transporter.model}</td>
							<td>${transporter.carAge}</td>
							<td>${transporter.cityArrive}</td>
							<td>${transporter.dateArrive}</td>
							<td>${transporter.status}</td>
							<td class="text-center">
							
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
</div>

</body>
</html>