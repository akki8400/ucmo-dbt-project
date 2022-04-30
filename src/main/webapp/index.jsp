<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>CS5200</title>
<style>
      body {
      background: linear-gradient(rgba(255,255,255,.5), rgba(255,255,255,.5)), url("images/movieMainPage.jpg");
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
        background-color: #1c87c9;
        color: #ffffff;
      }
      .header {
       	font-family: Arial, Helvetica, sans-serif;
       	padding: 1rem;
       	background-color: white;
       }
       

/* === BASE HEADING === */ 

h1 {
  position: relative;
  padding: 0;
  margin: 0;
  font-family: "Raleway", sans-serif;
  font-weight: 300;
  font-size: 40px;
  color: #080808;
  -webkit-transition: all 0.4s ease 0s;
  -o-transition: all 0.4s ease 0s;
  transition: all 0.4s ease 0s;
}

h1 span {
  display: block;
  font-size: 0.5em;
  line-height: 1.3;
}
h1 em {
  font-style: normal;
  font-weight: 600;
}


/* Style 7
   ----------------------------- */
.seven h1 {
text-align: center;
    font-size:30px; font-weight:300; color:#222; letter-spacing:1px;
    text-transform: uppercase;

    display: grid;
    grid-template-columns: 1fr max-content 1fr;
    grid-template-rows: 27px 0;
    grid-gap: 20px;
    align-items: center;
}

.seven h1:after,.seven h1:before {
    content: " ";
    display: block;
    border-bottom: 1px solid #c50000;
    border-top: 1px solid #c50000;
    height: 5px;
  background-color:#f8f8f8;
}


       
    </style>
</head>
<body>

<!--
<div class="header">
	<h1 style="text-align:center"></h1>
</div>
-->
<div class="header seven">
  <h1>MovieMate</h1>
</div>
	
	<form action="MovieRecomendation" method="post">
		<center>
	      	<input type="submit" name="recommendation" class="btn btn-dark" value="Explore More!">
	    </center>
	</form>
</body>
</html>