<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="dao.ActorsDao"%>
<%@page import="dao.MovieSearchDao"%>
<%@page import="dao.LanguageSearchDao"%>
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
<style>
	.link-button {
		border: 0px;
	    background: transparent;
	    text-decoration: underline;
	    color: blue;
	}
	.table-container {
		height: 85vh;
		overflow: auto;
	}
</style>
</head>
<body>

<div class="container">
  <h2>Movies</h2>
  <div class="table-container">
  <table class="table">
    <thead>
      <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Category</th>
		<th>Rating</th>
      </tr>
    </thead>
    <tbody>
    	<form action="MovieDetails" method="post">
        <c:forEach var="movie" items="${movieDetails}">
            <tr>
              <td><input class="link-button" type="submit" name="action_search" value="${movie.title}"></input></td>
              <td><c:out value="${movie.description}"/></td>
              <td><c:out value="${movie.category}"/></td>
              <td><c:out value="${movie.movieRating}"/></td>             
            </tr>
          </c:forEach>
         </form> 
    </tbody>
  </table>
  </div>
  <a class="btn btn-success" href="index.jsp">Search Movie</a>
  <h4 align="center">${error_message}</h4>
</div>

</body>
</html>