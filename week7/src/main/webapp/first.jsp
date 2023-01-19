<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<!-- jsp declaration -->
<%! int day =3;
	int fontsize=0;
%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to jsp..</h1>
<%= new java.util.Date().toString() %>
 <br>
<!-- scriptlet -->
<% out.println("Your IP adress is:"+ request.getRemoteAddr());%>


<%
	if(day==1 || day==7){
%>
	<p>Today is weekend</p>
<%
	}
	else 
%>
	<p>Today is weekday</p>

<%-- comment --%>
<% for (fontsize=1;fontsize<=3;fontsize++) { %>

	<font color ="green" size = <%=fontsize %>>
		JSP Tutorial
	</font><br>
<% } %>






</body>
</html>