<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.mca.demo.UserBean" %>
   <%@page import="com.mca.demo.DBUtill" %> 
   <%@page import="java.sql.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!UserBean u=null;ResultSet rs=null; %>
<%
//RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
String id=request.getParameter("t1");
String password=request.getParameter("t2");
rs=DBUtill.getData();
boolean status=false;
while(rs.next())
{
	if( (id.equals(rs.getString(1))) && (password.equals(rs.getString(2))  ))
	{
		status=true;
	}
}
if(status)
{
	out.println("Welcome "+id);
}
else
{
	out.println("Invalid user or password");
}
%>

</body>
</html>