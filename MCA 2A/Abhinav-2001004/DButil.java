package com.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DButil {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	
	public static Connection getConn()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/endterm","root","root");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return con;
	}
	public static ResultSet getData()throws Exception
	{
		con=getConn();
		pst=con.prepareStatement("select * from userdata");
		rs=pst.executeQuery();
		return rs;
	}
	public static int addData(UserBean b)throws Exception
	{
		int i=0;
		con=getConn();
		pst=con.prepareStatement("insert into login values(?,?)");
		pst.setString(1, b.getName());
		pst.setString(2, b.getPss());
		
		i=pst.executeUpdate();
		return i;	
	}
}
