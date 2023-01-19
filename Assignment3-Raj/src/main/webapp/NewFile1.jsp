<%@ taglib uri=”http://java.sun.com/jsp/jstl/core” prefix=”c” %> 
<html>  
<head>  
<title>Core Tag Example</title>  
</head>  
<body>  

 



<c:set var=”item” value=”2″/>

<c:choose>

<c:when test=”${item>0}”>

<c:out value=”1″/>

</c:when>

<c:when test=”${item==2}”>

<c:out value=”2″/>

</c:when>

<c:when test=”${item<2}”>

<c:out value=”3″/>

</c:when>

<c:otherwise>

<c:out value=”4″/>

</c:otherwise>

</c:choose>


</body>  
</html>  