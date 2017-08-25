<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <li class="nav-item">
        <a class="nav-link" href="/add-order">Add order</a>
      </li>
     
    </ul>
    <span class="navbar-text">
    <a href="/registration">Sign up</a>
    <a>or</a>
    <a href="/login">Log in</a>
    </span>
  </div>
  
  
</nav>
<h2 class="text-center">Add your order now!</h2>
<a href="/add-order" class="btn btn-outline-success text-center btn-block btn-lg">Add order</a>
	<h2>${message}</h2>
	<a href="/admin" class="btn btn-outline-dark">Admin</a>
	
</body>
</html>