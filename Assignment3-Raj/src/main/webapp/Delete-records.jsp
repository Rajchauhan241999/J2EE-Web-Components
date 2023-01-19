<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource
 var="db" driver="com.mysql.jdbc.Driver"
 url="jdbc:mysql://localhost:3306/A3"
 user="root" password="root"/>
 
 <sql:update dataSource="${db}" var="count">
DELETE FROM PRODUCT WHERE ProductNo=103;
 </sql:update>
 
 <sql:query dataSource="${db}" var="rs">
SELECT * from PRODUCT;
 </sql:query>
<table border="1">
<thead>
 <th>ProductNo</th>
 <th>ProductName</th>
 <th>ProductType</th>
 <th>Manufacturer</th>
 <th>Price</th>
 <th>Weight</th>
</thead>
<tbody>
<c:forEach var="i" items="${rs.rows}">
		<tr>
		<td> <c:out value="${i.ProductNo}"/></td>
		<td> <c:out value="${i.ProductName}"/></td>
		<td> <c:out value="${i.ProductType}"/></td>
		<td> <c:out value="${i.Manufacturer}"/></td>
		<td> <c:out value="${i.Price}"/></td>
		<td> <c:out value="${i.Weight}"/></td>
		</tr>
	</c:forEach>
</tbody>

</body>
</html>