<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String username=request.getParameter("username");
String password=request.getParameter("password");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("localhost", "root", "password");
PreparedStatement statement=con.prepareStatement("select username from userdata where username = ?");  
			statement.setString(1,username);
  
			int i=statement.executeUpdate();  
			System.out.println("Welcome"+username);  
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>