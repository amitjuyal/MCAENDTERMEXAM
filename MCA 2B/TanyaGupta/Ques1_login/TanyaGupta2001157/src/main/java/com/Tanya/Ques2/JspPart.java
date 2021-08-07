package com.Tanya.Ques2;
import java.sql.*;
public class JspPart {
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",".endterm", "tanya");
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
}