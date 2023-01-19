<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>  
<head>  
<title>Core Tag Example</title>  
</head>  
<body>  

<p> step 1: </p>
<c:set var="p" scope="session" value="${500}"/>
<c:out value="${p}"/>

<p> step 2: </p>
<c:set var="q" scope="session" value="${600}"/>   
<c:out value="${q}"/> 


<p> step 3: </p>
<p>${p} ${q}</p>

</body>  
</html>  