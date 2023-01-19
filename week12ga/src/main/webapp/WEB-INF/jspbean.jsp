<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<pre>
Employee ID: <input type="text" name="id"> Employee Name: <input type="text" name="name"> <input type="submit" value="submit">
</pre> </form>
<%if("get".equalsIgnoreCase(request.getMethod()) == true) { %>
<jsp:useBean id="e" class="week12ga.Employee" scope="page"> <jsp:setProperty name="e" property="*"/>

My id is <jsp:getProperty name="e" property="id"/> <br>
My name is <jsp:getProperty name="e" property="name" /> 
</jsp:useBean>
<br>

again this is my id = <=e.getId() %>
<br>
this is my name = <= e.getName() %>>
<% } %>
</body>
</html>