package com.databse.testing;
import java.util.Scanner;
import java.sql.*;
public class bookpractical {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","samikchhagurung", "stargazer");
		System.out.println("Enter Book Name: ");
		String bn=sc.nextLine();
		System.out.println("Enter Author Name: ");
		String au=sc.nextLine();
		System.out.println("Enter Number of Pages: ");
		int np=sc.nextInt();
		System.out.print("Enter Price: ");
		int pr=sc.nextInt();

		Statement st=con.createStatement();
		String sql="insert into bookdetails values(?,?,?,?)";

		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, bn);
		pst.setString(2, au);
		pst.setInt(3, np);
		pst.setInt(4, pr);

		int c=pst.executeUpdate();
		if(c!=0)
		{
		System.out.println("Data Inserted");
		}
		else
		{
		System.out.println("Data Not Inserted");
		}
		}
		
	}