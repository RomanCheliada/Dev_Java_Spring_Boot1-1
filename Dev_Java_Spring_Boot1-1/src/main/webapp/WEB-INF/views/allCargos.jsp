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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<title>Cargos</title>
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
      <li class="nav-item active">
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
			<form:form action="/cargos" method="GET" modelAttribute="cargoFilter">
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minWeight" class="form-control form-control-sm" placeholder="Min weight"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxWeight" class="form-control form-control-sm" placeholder="Max weight"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minHeight" class="form-control form-control-sm" placeholder="Min height"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxHeight" class="form-control form-control-sm" placeholder="Max height"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minWidth" class="form-control form-control-sm" placeholder="Min width"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxWidth" class="form-control form-control-sm" placeholder="Max width"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minLength" class="form-control form-control-sm" placeholder="Min length"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxLength" class="form-control form-control-sm" placeholder="Max length"/>
					  </div>
				</div>
				<div class="form-group row ">
					  <div class="col-4 ml-auto ">
					   		<form:input path="minPrice" class="form-control form-control-sm" placeholder="Min price"/>
					  </div>
					  <div class="col-4  mr-auto">
					   		<form:input path="maxPrice" class="form-control form-control-sm" placeholder="Max price"/>
					  </div>
				</div>
				<div class="form-group row">
					<div class="col-2 ml-auto ">
						<label>City from:</label>
						<form:select class="form-control-sm" path="cityFrom">
							<form:option value="">All</form:option>
							<form:options items="${citys}"/>
						</form:select>
					</div>
					<div class="col-2 ">
						<label>City to:</label>
						<form:select class="form-control-sm" path="cityTo">
							<form:option value="">All</form:option>
							<form:options items="${citys}"/>
						</form:select>
					</div>
					<div class="col-2 text-center ">
 						<button class="dropdown-toggle btn btn-outline-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
 						</button>
 						<div class="dropdown-menu">
 							<custom:sort innerHtml="Price: lowest first" paramValue="price"/>
 							<custom:sort innerHtml="Price: highest first" paramValue="price,desc"/>
 						</div>
 					</div>
		 			<div class="col-2 text-center mr-auto">
		 				<custom:size posibleSizes="1,2,5,10" size="${cargos.size}" />
		 			</div>
				</div>
				<div class="form-group row">
 						<div class="col-10 ml-auto">
         					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
         					<a href="/cargos/clean<custom:allParams/>" class="btn btn-outline-success btn-sm">Clean</a>
       					</div>
       			</div>
			</form:form>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
			<div class="col-12">
				<table class="table table-hover table-inverse">
				<thead>
					<tr>
						<th class="text-center">Owner</th>
						<th class="text-center">Goods</th>
						<th class="text-center">Weight</th>
						<th class="text-center">Dimensions</th>
						<th class="text-center">City from</th>
						<th class="text-center">City to</th>
						<th class="text-center">Price</th>
						<th class="text-center">Options</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach var="cargo" items="${cargos.content}">
						<tr>
							<td class="text-center">${cargo.owner}</td>
							<td class="text-center">${cargo.goods}</td>
							<td class="text-center">${cargo.weight} kg</td>
							<td class="text-center">${cargo.length}*${cargo.width}*${cargo.height} mm</td>
							<td class="text-center">${cargo.cityFrom}</td>
							<td class="text-center">${cargo.cityTo}</td>
							<td class="text-center">${cargo.price} Uah</td>
							<td class="text-center">
							<sec:authorize access="isAuthenticated()">
								<a href="/cargo/${cargo.id}"  class="btn btn-outline-light btn-sm">Details</a>
								</sec:authorize>
								<sec:authorize access="isAnonymous()">
								<a href="/login"  class="btn btn-outline-light btn-sm">Details</a>
								</sec:authorize>
							</td>
						</tr>
					</c:forEach>
						</tbody>
				</table>
			</div>
		</div>
		<div class="row">
 			<div class="col-md-12 col-xs-12 text-center">
 				<custom:pageable page="${cargos}"/>
 			</div>
 		</div>
</div>

</body>
</html>