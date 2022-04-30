<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="dao.ActorsDao"%>
<%@page import="dao.MovieSearchDao"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String errmsg = "";
    pageContext.setAttribute("errmsg", errmsg);
   
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.details-block {
	margin-top: 15rem;
	line-height: 2.5rem;
}
</style>
</head>
<body>

<div class="container">
  <center><h2>Movie</h2></center>
  <c:forEach var="movie" items="${movieDetails}">
	  <div class="row">
	  	<div class="col-md-4">
	  		<h2>${movie.title}</h2>
	    	<img class="card-img-top img-rounded" src="images/${movie.imageName}.jpg" alt="Card image cap">
	    </div>
	   	<div class="col-md-6 details-block">
	   		<br/><b>Description</b>
			<c:out value="${movie.description}"/>
			<br/><b>Features</b>
			<c:out value="${movie.movieFeatures}"/>
			<br/><b>Rating</b>
			<c:out value="${movie.movieRating}"/>
			<br/><b>Language</b>
			<c:out value="${movie.langage}"/>
			<br/><b>Year</b>
			<c:out value="${movie.releaseYear}"/>
			<br/><b>Actor</b>
			<c:out value="${movie.actorFirstName} ${movie.actorLastName}"/>
			<br/><b>Duration</b>
			<c:out value="${movie.movieLength}"/>
			<br/><b>Rental Rate</b>
			<c:out value="${movie.rentalRate}"/>
			<br/><b>Rental Duration</b>
			<c:out value="${movie.rentalDuration}"/>
	   	</div>
	 </div>
 </c:forEach>
<br/><br/>
<a class="btn btn-success" href="index.jsp">Search Movie</a>
</div>
</body>
</html>