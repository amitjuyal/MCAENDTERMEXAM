package com.database.test;
import java.sql.*;
import java.util.Scanner;
public class insertd {
	public static void main(String[] args) {
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					String url="jdbc:mysql://localhost/test";
					String user="root";
					String pswd="rohan";
					Connection con=DriverManager.getConnection(url,user,pswd);
					Scanner sc=new Scanner(System.in);
					String bname=sc.next();
					String aname=sc.next();
					int pages=sc.nextInt();
					int price=sc.nextInt();
					String sql="insert into bookdetails values(?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, bname);
					pst.setString(2, aname);
					pst.setInt(3, pages);
					pst.setInt(4, price);
					pst.close();
					con.close();  
				}
				catch(SQLException s) {
					s.printStackTrace();
				}
				catch(ClassNotFoundException c) {
					c.printStackTrace();
				}
				}
	}
		
