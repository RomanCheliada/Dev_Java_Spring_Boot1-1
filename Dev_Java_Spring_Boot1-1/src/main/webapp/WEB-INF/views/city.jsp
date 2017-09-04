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
<title>City</title>
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
      <li class="nav-item active">
      <a class="nav-link" href="/admin/city">City <span class="sr-only">(current)</span></a>
     
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
      <li class="nav-item">
        <a class="nav-link" href="/admin/owner">Owner</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin/transporter">Transporter</a>
      </li>
    </ul>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
    	<form:form >
 			<a href="/" style="margin: 5px" class="btn btn-outline-info btn-sm">User</a>
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
				<form:form action="/admin/city" method="POST" modelAttribute="city">
					<div class="form-group row" style="margin-top:5px;">
						<label class="col-1 col-form-label">Name:</label>
						<div class="col-9">
							<form:input path="name" class="form-control"/>
						</div>
						<div class="col-2 offset-sm-2">
        					<button type="submit" class="btn btn-outline-success">Save</button>
        					<a href="/admin/city/cancel" class="btn btn-outline-warning ">Cancel</a>
      					</div>
					</div>
					<div class="form-group row">
						<div class="col-11 ml-auto" style="color:red;">
							<form:errors path="name"/>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-hover">
				<thead>
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Options</th>
					</tr>
					</thead>
					<c:forEach var="city" items="${citys}">
					<tbody>
						<tr>
							<td class="text-center">${city.name}</td>
							<td class="text-center">
								<a href="/admin/city/update/${city.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/admin/city/delete/${city.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>