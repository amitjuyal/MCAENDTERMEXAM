package com.login.com;

import java.sql.*;

public class log {

		static Connection con=null;
		static PreparedStatement pst=null;
		static ResultSet rs=null;
		public static Connection getConn()
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","endterm","name");
			}catch(Exception e)
			{
				System.out.print(e);

			}
			return con;
			
		}
		
		public static ResultSet getData() throws Exception
		{
			con=getConn();
			pst=con.prepareStatement("select * from username");
			rs=pst.executeQuery(); 
			return rs;
		}
		public static int addData(userbean b)throws Exception
		{
			int i=0;
			con=getConn();
			pst=con.prepareStatement("insert into username values(?,?)");
			pst.setString(1,b.getUsername());
			pst.setString(2,b.getPassword());
			i=pst.executeUpdate();
			return i;
		}
		
		
}
