<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Cargo</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Easy Trans</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cargos">Cargos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/transporters">Transporters</a>
      </li>
      <li class="nav-item">
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
    <a>or</a>
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
		<div class="col-10">
			<h3 style="margin:15px;">Owner ${cargo.owner}</h3> 
		</div>
		<div class="col-2">
			<a style="margin:15px;" href="/owner/${owner.id}" class="btn btn-outline-dark">More</a>
		</div>
	</div>
	<div class="row">
	<div class="col-12">
        <h4 class="text-center"><a  style="color: green;">${addTakeJob}</a></h4>
        </div>
     </div>
	<div class="row">
		<div class="col-6">
			<h4 style="margin-top:15px;" class="text-center">Goods:</h4><br>
			<h4  class="text-center">Weight:</h4><br>
			<h4  class="text-center">Length:</h4><br>
			<h4  class="text-center">Width:</h4><br>
			<h4  class="text-center">Height:</h4><br>
			<h4  class="text-center">City (from - to):</h4><br>
			<h4  class="text-center">Price:</h4><br>
		</div>
		<div class="col-6">
			<h4 style="margin-top:15px;" class="text-center">${cargo.goods}</h4><br>
			<h4 class="text-center">${cargo.weight} kg</h4><br>
			<h4 class="text-center">${cargo.length} mm</h4><br>
			<h4 class="text-center">${cargo.width} mm</h4><br>
			<h4 class="text-center">${cargo.height} mm</h4><br>
			<h4 class="text-center">${cargo.cityFrom} - ${cargo.cityTo}</h4><br>
			<h4 class="text-center">${cargo.price} Uah</h4><br>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-12 offset-sm-12">
			<sec:authorize access="hasRole('ROLE_TRANSPORTER')">
        		<a href="/cargo/${cargo.id}/takeJob" class="btn btn-primary btn-block btn-outline-success">Take a job</a>
        	</sec:authorize>
        	
		</div>
	</div>
</div>
</body>
</html>