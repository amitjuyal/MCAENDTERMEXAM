/Tarun Dumka 
//2001158
import java.sql.*;
import java.util.*;
public class Book
{
	public static void main(String[] args)
	{
	
	try
		{
		   
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Mayur","root", "root");
		PreparedStatement ps =con.prepareStatement("insert into book values(?,?,?,?)");   
		Scanner sc =new Scanner(System.in);	
		
		do	{  
			System.out.println("enter bookname:");  
			String bookname=sc.nextLine();  
			System.out.println("enter authorname:");  
			String authorname=sc.nextLine();  
			System.out.println("enter no. of pages:");  
			int no_page=sc.nextInt();  
			System.out.println("Price");  
			int price=sc.nextInt();  
  
			ps.setString(1,bookname);  
			ps.setString(2,authorname);
  			ps.setInt(3,no_page); 
			ps.setInt(4,price);  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
  
			System.out.println("Do you want to continue: y/n");  
			String s=sc.nextLine();  
			if(s.startsWith("n")){  
			break;  
			
			}}while(true);  
	   	}
	catch (SQLException e) { System.out.println(e);}
	con.close();
	}
}


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login.jsp">
Enter user name:<input type="text" name="t1"><br>
Enter password:<input type="password" name="t2"><br>
<input type="submit" value="login"><br>
<a href="newuser.html">new_user</a>

</form>

</body>
</html>




package com.mca.tarundumka2001158;
import java.sql.*;

public class DButile {
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	public static Connection getConn()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","root123");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
		
	}
	public static ResultSet getData() throws Exception
	{
		con=getConn();
		pst=con.prepareStatement("select * from user");
		rs=pst.executeQuery();
		return rs;
	}
	public static int addData(UserBean b)throws Exception
	{
		int i=0;
		con=getConn();
		pst=con.prepareStatement("insert into user values(?,?,?,?");
		pst.setString(1,b.getName());
		pst.setString(2,b.getPassword() );
		pst.setInt(3,b.getAge());
		pst.setInt(4, b.getPhone());
		i=pst.executeUpdate();
		return i;
	}

}







