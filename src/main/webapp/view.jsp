<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="dao.ActorsDao"%>
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
<title>Actors</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Actors</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Actor Id</th>
        <th>Actor First Name</th>
        <th>Actor Last Name</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var="actor" items="${actors_details}">
            <tr>
              <td><c:out value="${actor.actorId}"/></td>
              <td><c:out value="${actor.firstName}"/></td>
              <td><c:out value="${actor.lastName}"/></td>
            </tr>
          </c:forEach>
                  
    </tbody>
    <tr>
          <td><a class="btn btn-success" href="index.jsp">Search Actor</a></td>
    </tr> 
  </table>
</div>
</body>
</html>