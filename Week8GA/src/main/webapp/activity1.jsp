<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post">
<pre>
First name: <input type="text" name="firstName">
Email address 1: <input type="text" name="email">
Email address 2: <input type="text" name="email">
<input type="Submit" name="Submit">
</pre>
</form>

First name: ${param.firstName}<br>
Email address 1: ${paramValues.email[0]}<br>
Email address 2: ${paramValues.email[1]}




</body>
</html>