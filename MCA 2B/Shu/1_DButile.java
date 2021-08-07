package com.mca.shubhamsaklani20711101 ;
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
