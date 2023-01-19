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


<p>Product NO: <input type="text" name="pno"></p>
<p>Product Name: <input type="text" name="pname"></p>

<p>Product Type:
<select name="pt" id="pt">
  <option value="Home Appliance">Home Appliance</option>
  <option value="Computer Hardware">Computer Hardware</option>
  <option value="Game Console">Game Console</option>
  <option value="Clothing">Clothing</option>
</select>
</p>

<p>Manufacturer: <input type="text" name="m"></p>
<p>Price: <input type="text" name="pri"></p>
<p>Weight: <input type="text" name="w"></p>

<p><input type="submit" name="Add Product"></p>


</form>


<h3>The fallowing information is received</h3>
<p>Product No: ${param.pno}<br>
Product Name: ${param.pname}<br>
Product Type: ${param.pt}<br>
Manufacturer: ${param.m}<br>
Price: ${param.pri}<br>
Weight: ${param.w}<br>
</p>

</body>
</html>