<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Login</title>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/">Easy Trans</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">

			</ul>
			<span class="navbar-text"> <a href="/registration">Sign up</a>
			</span>
		</div>


	</nav>
<body>
	<div class="container">
		<div class="row">
			<div class=" col-12 ">
				<c:if test="${param.fail}">
	 			<div class="col-12 text-center" style="color:red;">
	 				Fail to authorize. Try again
	  			</div>
	  			</c:if>
				<form:form action="/login" method="POST">
					<div class="form-group row">
						<label class="form-col-label col-2 text-center" for="email">Email:</label>
						<div class="col-10">
							<input name="login" id="email" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="form-col-label col-2 text-center" for="password">Password:</label>
						<div class="col-10">
							<input type="password" name="password" id="password"
								class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10">
							<label><input type="checkbox" name="rememberMe">
								Remember me</label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12 ml-auto">
							<button type="submit"
									class="btn btn-primary btn-block btn-outline-success">Log in</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>