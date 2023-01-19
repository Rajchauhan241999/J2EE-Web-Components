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
 url="jdbc:mysql://localhost:3306/WEEK8"
 user="root" password="root"/>
 
  <sql:update dataSource="${db}" var="count">
INSERT INTO EMP VALUES ('30','raj','Programmer','1');
 </sql:update>
 
<sql:query dataSource="${db}" var="rs">
SELECT * from EMP;
 </sql:query>
<table border="1">
<thead>
 <th>EmpNo</th>
 <th>EmpName</th>
 <th>Job</th>
 <th>Salary</th>
</thead>
<tbody>
<c:forEach var="i" items="${rs.rows}">
		<tr>
		<td> <c:out value="${i.EmpNo}"/></td>
		<td> <c:out value="${i.EmpName}"/></td>
		<td> <c:out value="${i.Job}"/></td>
		<td> <c:out value="${i.Salary}"/></td>
		</tr>
	</c:forEach>
</tbody>

</table>
</body>
</html>