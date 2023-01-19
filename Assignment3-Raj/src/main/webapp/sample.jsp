<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<html>
  <head>
	<title>fmt:formatNumber JSTL formatting tag example</title>
  </head>
  <body>
    <c:set var="num" value="544123.23234"/>
    Number after setting type attribute: <br/>
    <fmt:formatNumber value="${num}" type="currency"/> <br/>
    
    
    Number after setting maxIntegerDigits and maxFractionDigits attribute:
    <br/>
    <fmt:formatNumber type="number" maxIntegerDigits="4" 
    maxFractionDigits="3" value="${num}" /> <br/>
    
    
    Number after setting pattern attribute: <br/>
    <fmt:formatNumber type="number" pattern="##,###.##" value="${num}" />
	</body>
</html>