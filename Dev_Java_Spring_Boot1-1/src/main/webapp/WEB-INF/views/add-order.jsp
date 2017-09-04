<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Add order</title>
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
      <li class="nav-item ">
        <a class="nav-link" href="/transporters">Transporters</a>
      </li>
      <sec:authorize access="isAuthenticated()" >
      <li class="nav-item active">
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
    <a style="color:white;">or</a>
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
	      					<sec:authorize access="hasRole('ROLE_TRANSPORTER')">
							<h2>Please register as 'Owner'! Thanks</h2>
							</sec:authorize>
				<form:form action="/add-order" method="POST" modelAttribute="cargo">
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="goods"/>
						</div>
					</div>
					<div style="margin-top:10px;" class="form-group row">
						<label class="col-2 col-form-label">Goods:</label>
						<div class="col-10">
							<form:select path="goods" class="form-control">
								<form:option value="NONE">Select</form:option>
								<form:options items="${goodss}"></form:options>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="weight"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Weight:</label>
						<div class="col-10">
							<form:input path="weight" class="form-control"/> 
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="height"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Height:</label>
						<div class="col-10">
							<form:input path="height" class="form-control"/> 
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="width"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Width:</label>
						<div class="col-10">
							<form:input path="width" class="form-control"/> 
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="length"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Length:</label>
						<div class="col-10">
							<form:input path="length" class="form-control"/> 
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="cityFrom"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">City from:</label>
						<div class="col-10">
							<form:select path="cityFrom" class="form-control">
								<form:option value="">Select</form:option>
								<form:options items="${cities}"></form:options>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="cityTo"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">City to:</label>
						<div class="col-10">
							<form:select path="cityTo" class="form-control">
								<form:option value="">Select</form:option>
								<form:options items="${cities}"></form:options>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="price"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Price:</label>
						<div class="col-10">
							<form:input path="price" class="form-control"/> 
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12 offset-sm-12">
						<sec:authorize access="hasRole('ROLE_OWNER')">
        					<button type="submit" class="btn btn-primary btn-block btn-outline-success">Add</button>
        					</sec:authorize>
      					</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</html>