<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld" %>
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
				<table class="table table-hover">
				<thead>
					<tr>
						<th class="text-center">Photo</th>
						<th class="text-center">Name</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Max weight</th>
						<th class="text-center">Count</th>
						<th class="text-center">Options</th>
					</tr>
					</thead>
					<c:forEach var="transporter" items="${transporters.content}">
					<tbody>
						<tr>
													<td  class="text-center">		<img src="data:image/png;base64,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" class="rounded " alt="..."></td>
							<td  class="text-center"><h4>Name:</h4><br><h4>${transporter.name}</h4></td>
							<td class="text-center"><h4>Rate:</h4><br><h4>${transporter.rate}</h4></td>
							<td class="text-center"><h4>Max weight:</h4><br><h4>${transporter.maxWeight} kg</h4></td>
							<td class="text-center"><h4>Count:</h4><br><h4>${transporter.count}</h4></td>
							<td class="text-center">
								<a href="/transporter/${transporter.id}"  class="btn btn-outline-dark ">Details</a><br>
								<a href="/admin/owner/delete/${transporter.id}" class="btn btn-outline-danger">Delete</a>
							</td>
						</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-xs-12 text-center">
				<custom:pageable page="${transporters}"/>
			</div>
		</div>
</div>

</body>
</html>