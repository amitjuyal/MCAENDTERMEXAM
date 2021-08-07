<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Sagar.Ques2.UserBean" %>
    <%@page import="com.Sagar.Ques2.JspPart" %>
     <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! UserBean u=null ; ResultSet rs=null; %>
<%
RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
String UserName = request.getParameter("usrnm");
String Psw = request.getParameter("psw");
rs=JspPart.getData();
boolean status=false;
while(rs.next())
{
	if( (UserName.equals(rs.getString(2))) && (Psw.equals(rs.getString(3))) )
	{
		 status=true;
	}
}
if(status)
{
	rd.forward(request,response);
	}
else
{
	out.println("Invalid Credentials(UserName and Password)");
	}
%>
</body>
</html>