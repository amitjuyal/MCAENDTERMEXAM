<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.login.com.userbean"%>
<%@ page import="com.login.com.log"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! userbean u=null; ResultSet rs=null; %>
	<%
		RequestDispatcher rd= request.getRequestDispatcher("done.jsp");
		String id=request.getParameter("t1");
		String psw=request.getParameter("t2");
		rs=log.getData();
		boolean st=false;
		while(rs.next())
		{
			if(id.equals(rs.getString(1)) && psw.equals(rs.getString(2)))
			{
				st=true;
			}
		}
		if(st)
		{
			rd.forward(request, response);
		}
		else
		{
			out.println("invalid");
		}
	
	
	%>>
</body>
</html>