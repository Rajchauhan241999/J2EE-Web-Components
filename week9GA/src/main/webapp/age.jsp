<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="test" value="2" scope="request"></c:set>
<form >
<pre>
Age:<input type="text" name="age">
<input type="submit" value="Calculate">

</pre>
</form>
 
 <pre>
 <c:choose>
<c:when test='${param.age =="" || param.age == null || param.age < 0 || param.age > 100}'> 
<h5>Age Should not be empty or age should be between 0 and 100</h5>
</c:when>
<c:otherwise>
Age after 10 years '${param.age+10}'

my variable = <%= request.getAttribute("test")%>
</c:otherwise>
</c:choose>
</pre>

</body>
</html>