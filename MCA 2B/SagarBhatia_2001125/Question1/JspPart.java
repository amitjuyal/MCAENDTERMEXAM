package com.Sagar.Ques2;
import java.sql.*;
public class JspPart {
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","endterm", "endterm");
		}
		catch(Exception e){System.out.println(e);}
		return con;
	}
	public static ResultSet getData() throws Exception{
		con=getConn();
		pst=con.prepareStatement("select * from userdata");
		rs=pst.executeQuery();
		return rs;
	}
	public static int addData(UserBean b) throws Exception
	{
		int i=0;
		con=getConn();
		pst=con.prepareStatement("insert into userdata values(?,?,?)");
		pst.setInt(1, b.getId());
		pst.setString(2,b.getName());
		pst.setString(3,b.getPswd());
		i=pst.executeUpdate();
		return i;
	}
}