<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <a class="navbar-brand" href="/admin">Easy Trans </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="/admin">Home </a>
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
      <li class="nav-item active">
        <a class="nav-link" href="/admin/cargo">Cargo<span class="sr-only">(current)</span></a>
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
				<form:form action="/admin/cargo" method="POST" modelAttribute="cargo">
					<div class="form-group row">
						<label class="col-2 col-form-label">Goods:</label>
						<div class="col-10">
							<form:select path="goods" class="form-control">
								<form:option value="">Select</form:option>
								<form:options items="${goodss}"></form:options>
							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Weight:</label>
						<div class="col-10">
							<form:input path="weight" class="form-control"/> 
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Height:</label>
						<div class="col-10">
							<form:input path="height" class="form-control"/> 
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Width:</label>
						<div class="col-10">
							<form:input path="width" class="form-control"/> 
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Length:</label>
						<div class="col-10">
							<form:input path="length" class="form-control"/> 
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
					<div class="form-group row">
						<label class="col-2 col-form-label">City to:</label>
						<div class="col-10">
							<form:select path="cityTo" class="form-control">
								<form:option value="">Select</form:option>
								<form:options items="${cities}"></form:options>
							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label">Price:</label>
						<div class="col-10">
							<form:input path="price" class="form-control"/> 
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 offset-sm-2">
        					<button type="submit" class="btn btn-outline-success">Save</button>
        					<a href="/admin/cargo/cancel" class="btn btn-outline-warning ">Cancel</a>
      					</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Goods</th>
						<th class="text-center">Weight</th>
						<th class="text-center">Height</th>
						<th class="text-center">Width</th>
						<th class="text-center">Length</th>
						<th class="text-center">City from</th>
						<th class="text-center">City to</th>
						<th class="text-center">Price</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="cargo" items="${cargos}">
						<tr>
							<td>${cargo.goods}</td>
							<td>${cargo.weight}</td>
							<td>${cargo.height}</td>
							<td>${cargo.width}</td>
							<td>${cargo.length}</td>
							<td>${cargo.cityFrom}</td>
							<td>${cargo.cityTo}</td>
							<td>${cargo.price}</td>
							<td class="text-center">
								<a href="/admin/cargo/update/${cargo.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/admin/cargo/delete/${cargo.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>