<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A New Friend</title>
</head>
<body>
	<form name="addForm" action ="addFriend" method="get">
	
		<label>Friend ID:</label>
		<input type="text" name="id" value="" />
		<br><br>
		
		<label>Friend Name:</label>
		<input type="text" name="name" value="" />
		<br><br>
		
		<label>Email Address:</label>
		<input type="text" name="email" value="" />
		<br><br>
		
		<label>Age:</label>
		<input type="text" name="age" value="" />
		<br><br>
		
		<label>Favorite Color:</label>
		<input type="text" name="color" value="" />
		<br><br>
		
		
		<input type="submit" name="submit" value="Submit" />
		
	</form>
</body>
</html>