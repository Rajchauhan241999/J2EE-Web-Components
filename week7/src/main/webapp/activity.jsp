<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
    <%! ResultSet rs; %>
  <% 
    Connection con;
    try{
    
    Class.forName("com.mysql.jdbc.Driver");
    String dburl ="jdbc:mysql://localhost:3306/week7";
    String uname ="root";
	String password ="root";
    con = DriverManager.getConnection(dburl, uname, password);
    System.out.println(con.isClosed());
    
    
    String sql = "INSERT into EMP VALUES (?,?,?,?)";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, request.getParameter("EMPNO"));
    pst.setString(2, request.getParameter("EMPNAME"));
    pst.setString(3, request.getParameter("JOB"));
    pst.setString(4, request.getParameter("SAL"));
    
    
    pst.executeUpdate();
    Statement st =con.createStatement();
    String sqlSelect = "select * from EMP";
    st.executeQuery(sqlSelect);
    ResultSet rs = st.executeQuery(sqlSelect);
    
    
    
    //pst.execute();
    }catch(Exception e){
    	e.printStackTrace();
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<thead>
<tr>
	<th>Employee NO</th>
	<th>Employee name </th>
	<th>Job</th>
	<th>Salary</th>
</tr>
</thead>

<tbody>
	<%
		try{
			while(rs.next())
		
	%>
	
	<tr>
		<td><%= rs.getString("EMPNO") %></td>
		<td><%= rs.getString("EMPNAME") %></td>
		<td><%= rs.getString("JOB") %></td>
		<td><%= rs.getString("SAL") %></td>
	</tr>	
	
	<%
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
</tbody>
</table>



</body>
</html>