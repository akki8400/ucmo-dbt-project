<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CS5200</title>
<style>
      body {
        background-color: #C7FF33;
      }
      form {
        width: 400px;
        margin: auto;
        margin-top: 250px;
      }
      input {
        padding: 4px 10px;
        border: 0;
        font-size: 16px;
      }
      .search {
        width: 75%;
      }
      .submit {
        width: 70px;
        background-color: #1c87c9;
        color: #ffffff;
      }
    </style>
</head>
<body>
<h1 style="text-align:center">MovieMate</h1>
<form action="actorServlet" method="post">
      <input type="text" name="actor_name" class="search" placeholder="Search here!">
      <input type="submit" name="action" class="submit" value="Search">
</form>
<h4 color="red" align="center">${error_message}</h4>
</body>
</html>