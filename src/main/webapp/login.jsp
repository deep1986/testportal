<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<style>

<meta name="viewport" content="width=device-width, initial-scale=1">
body, html {
  height: 100%;
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("img1.jpg");

  min-height: 380px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
</head>
<!-- <body class="bg-img"> -->

<body background="resources/img/img1.jpg">
<h1 align="center">Success EduHub</h1>

<div class="bg-img">
<form action="Login" method="post" >
<table style="float:center" align="center">
<tr>
<td>
<label style="color:red"><%



if (request.getAttribute("results")==null)
{

} else
{
	String result = request.getAttribute("results").toString();
%>
<%= result.toString() %>
<%
}
%></label>
<h2>Login</h2>
<label for="emailid"><b>UserName</b></label>
</td>
</tr>
<tr>
<td>
<input type="text" placeholder="Enter Email" name="emailid" required/>
</td>
</tr>
<tr>
<td>
<label for="password"><b>Password</b></label>
</td>
</tr>
<tr>
<td>
<input type="password" placeholder="Enter Password" name="password" required/>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" name="submitbtn" class="btn" value="Login"/>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>