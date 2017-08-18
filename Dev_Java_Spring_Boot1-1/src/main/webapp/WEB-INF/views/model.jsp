<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Model</title>
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
      <li class="nav-item ">
       <a class="nav-link" href="/admin/city">City</a>
     
      </li>
      <li class="nav-item ">
      <a class="nav-link" href="/admin/goods">Goods</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/admin/model">Model <span class="sr-only">(current)</span></a>
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
    <span class="navbar-text">
      admin@gmail.com
    </span>
  </div>
</nav>
<div class="container">
<div class="row">
			<div class="col-12">
				<form action="/admin/model" method="POST">
					<div class="form-group row">
						<label class="col-1 col-form-label">Name:</label>
						<div class="col-9">
							<input name="name" class="form-control">
						</div>
						<div class="col-2 offset-sm-2">
        					<button type="submit" class="btn btn-outline-success">Save</button>
      					</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="model" items="${models}">
						<tr>
							<td>${model.name}</td>
							<td class="text-center">
								<a href="/admin/model/update/${model.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/admin/model/delete/${model.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>