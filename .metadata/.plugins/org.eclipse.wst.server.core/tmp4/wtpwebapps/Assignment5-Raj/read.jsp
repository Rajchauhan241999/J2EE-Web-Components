<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSp page</title>
</head>

<% String table  = (String) request.getAttribute("table"); %>
<body>
	<h1>Raj's Friend</h1>
	<%= table %>
	
	<br>
	<a href= "add">Add A New Friend </a>
	
	

</body>
</html>