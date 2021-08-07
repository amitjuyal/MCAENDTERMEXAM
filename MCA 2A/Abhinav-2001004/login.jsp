<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.login.UserBean" %>
 <%@page import="com.login.DButil" %>
 <%@page import="java.sql.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! UserBean u=null; ResultSet rs=null; %>
	<%
		RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
		String id =request.getParameter("user_name");
		String psw =request.getParameter("user_password");
			
		rs = DButil.getData();
			boolean status=false;
			while(rs.next()){
				if(id.equals(rs.getString(1))  && psw.equals(rs.getString(2))){
					status=true;
				}
			}
			if(status){
				rd.forward(request, response);
			}
			else{
				out.println("Invaild User and Password....");
			}
	%>
</body>
</html>