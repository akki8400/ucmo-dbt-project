<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="dao.ActorsDao"%>
<%@page import="dao.MovieSearchDao"%>
<%@page import="dao.LanguageSearchDao"%>
<%@page import="dao.RecommendationDao"%>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <style>
            .submit {
            border: none;
            background: white;
            color: blue;
            }
            .search-container{
  width: 490px;
  display: block;
  margin: 0 auto;
}

input#search-bar{
  margin: 0 auto;
  width: 100%;
  height: 45px;
  padding: 0 20px;
  font-size: 1rem;
  border: 1px solid #D0CFCE;
  outline: none;
  &:focus{
    border: 1px solid #008ABF;
    transition: 0.35s ease;
    color: #008ABF;
    &::-webkit-input-placeholder{
      transition: opacity 0.45s ease; 
  	  opacity: 0;
     }
    &::-moz-placeholder {
      transition: opacity 0.45s ease; 
  	  opacity: 0;
     }
    &:-ms-placeholder {
     transition: opacity 0.45s ease; 
  	 opacity: 0;
     }    
   }
 }

.search-icon{
  position: relative;
  float: right;
  width: 75px;
  height: 75px;
  top: -62px;
  right: -45px;
}
.margin-around {
	margin: 0.2rem;
}
.card {
	padding: 3px;
	margin-bottom: 10px;
}
.card-img-top {
	width: 100%;
	height: 14rem;
}
.card-title {
	background: transparent;
    border: 0px;
    text-decoration: underline;
    color: blue;
}
        </style>
        <div class="container">
        	<center>
            <h2>Movies</h2>
            <form action="CategorySearch" method="post">
            	<c:forEach var="cate" items="${categoryList}">
  			          <button type="submit" name="categorySearch" class="btn btn-primary margin-around" value="${cate.category}">${cate.category}</button>
            	</c:forEach>
            </form>
            </center>
			<br/>
			
			 <form class="search-container" action="MovieSearch" method="post">
			    <div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Search Movie name" aria-label="searchName" name="searchName" aria-describedby="basic-addon2" >
				  <div class="input-group-append">
				    <span class="input-group-text" id="basic-addon2"><button type="submit" name="searchSubmit" class="btn btn-warning">Search</button></span>
				  </div>
				</div>
			  </form>
			  
            <form action="MovieRecomendation" method="post">
                <div class="row">
                    <c:forEach var="movie" items="${movieDetails}">
                    	<!--  <input type="hidden" value="${movie.title}" name="${movie.title}" id="${movie.title}"/> -->
                        <div class="col-sm-3">
                        	<form action="MovieDetails" method="post" name="action_search" id="action_search">
                            <div class="card">
                                <img class="card-img-top" src="images/${movie.imageName}.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <button type="submit" form="action_search" class="card-title" name="action_search" value="${movie.title}">${movie.title}</button>
                                    <p class="card-text">${movie.category}</p>
                                </div>
                            </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </form>
        </div>
    </body>
</html>