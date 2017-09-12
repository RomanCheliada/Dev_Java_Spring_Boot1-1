<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Owners</title>
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
      <li class="nav-item">
        <a class="nav-link" href="/transporters">Transporters</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/owners">Owners</a>
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
    <a style="color:white; margin:5px;">or</a>
    <a href="/login" class="btn btn-outline-info btn-sm">Log in</a>
    </sec:authorize>
     <sec:authorize access="isAuthenticated()">
     <a  style="color: white; margin: 5px;">${message}</a>
     </sec:authorize>
     <sec:authorize access="isAuthenticated()">
     <a href="/profile" style="margin: 5px" class="btn btn-outline-info btn-sm ">Profile</a>
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
				<thead>
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Count</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Address</th>
						<th class="text-center">Options</th>
					</tr>
					</thead>
					<c:forEach var="owner" items="${owners.content}">
					<tbody>
						<tr>
							<td class="text-center">${owner.name}</td>
							<td class="text-center">${owner.count}</td>
							<td class="text-center">${owner.phone}</td>
							<td class="text-center">${owner.address}</td>
							<td class="text-center">
							<sec:authorize access="isAuthenticated()">
								<a href="/owner/${owner.id}"  class="btn btn-outline-light btn-sm">Details</a>
								</sec:authorize>
								<sec:authorize access="isAnonymous()">
								<a href="/login"  class="btn btn-outline-light btn-sm">Details</a>
								</sec:authorize>
							</td>
						</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
 			<div class="col-md-12 col-xs-12 text-center">
 				<custom:pageable page="${owners}"/>
 			</div>
 		</div>
</div>
</body>
</html>