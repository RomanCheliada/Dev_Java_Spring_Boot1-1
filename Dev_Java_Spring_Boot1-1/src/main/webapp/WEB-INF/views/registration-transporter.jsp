<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Register</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Easy Trans</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
     
    </ul>
    <a href="/login" class="btn btn-outline-info btn-sm">Log in</a>
  </div>
  
  
</nav>

<div class="container">
		<div class="row ">
			<div class=" col-12 ">
				<form:form action="/registration-transporter" method="POST"
					modelAttribute="transporter">
					<div class="form-group row">
						<div class="col-12">
							<a class="breadcrumb-item " href="/registration">Owner</a>
							<a class="breadcrumb-item active" href="/registration-transporter">Transporter</a>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-2 text-center" for="email">Email:</label>
						<div class="col-10">
							<form:input path="email" id="email" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-2 text-center" for="password">Password:</label>
						<div class="col-10">
							<form:password path="password" id="password" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-2 text-center" for="repeatpassword">Repeat
							password:</label>
						<div class="col-10">
							<form:password path="repeatPassword" id="repeatpassword"
								class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label text-center">Name:</label>
						<div class="col-10">
							<form:input path="name" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label text-center">Age:</label>
						<div class="col-10">
							<form:input path="age" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label text-center">Phone:</label>
						<div class="col-10">
							<form:input path="phone" class="form-control" placeholder="(012)-34-56-789"/>
						</div>

					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label text-center">Model:</label>
						<div class="col-10">
							<form:select path="model" class="form-control">
								<form:option value="NONE">Select</form:option>
								<form:options items="${models}"></form:options>
							</form:select>
						</div>

					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label text-center">Year issue:</label>
						<div class="col-10">
							<form:input path="carAge" class="form-control"/>
						</div>

					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label text-center">Max weight:</label>
						<div class="col-10">
							<form:input path="maxWeight" class="form-control"/>
						</div>

					</div>
					<div class="form-group row">
						<div class="col-12 offset-sm-12">
							<button type="submit" class="btn btn-primary btn-block btn-outline-success">Register</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>

	</div>

</body>
</html>