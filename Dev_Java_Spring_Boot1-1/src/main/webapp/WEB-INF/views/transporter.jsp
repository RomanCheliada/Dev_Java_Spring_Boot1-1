<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Transporter</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/admin">Easy Trans </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="/admin">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/brand">Brand</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/city">City</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/goods">Goods</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/model">Model</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/cargo">Cargo</a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="/admin/owner">Owner</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/admin/transporter">Transporter <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <span class="navbar-text">
      <sec:authorize access="hasRole('ROLE_ADMIN')">
    	<form:form >
 			<a href="/" class="btn btn-outline-info btn-sm">User</a>
 		</form:form>
    </sec:authorize>
    </span>
    <span class="navbar-text">
    <sec:authorize access="isAuthenticated()">
    	<form:form action="/logout">
 			<button class="btn btn-outline-info btn-sm">Log out</button>
 		</form:form>
    </sec:authorize>
    </span>
  </div>
  
</nav>
<div class="container">
	<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
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
								<a href="/admin/transporter/delete/${transporter.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
</div>

</body>
</html>