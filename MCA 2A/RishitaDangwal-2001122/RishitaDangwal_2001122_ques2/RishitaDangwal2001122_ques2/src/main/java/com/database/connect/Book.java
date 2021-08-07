package com.database.connect;
import java.sql.*;
import java.util.Scanner;
public class Book {
	public static void main(String[] args) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","9214");
			System.out.println("Connected");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter number of records");
			int n=sc.nextInt();
			PreparedStatement pst=conn.prepareStatement("insert into bookdetails values(?,?,?,?)");
			String bookname=null,authorname=null;
			int pages=0,price=0;
			while(n>0)
			{
				System.out.println("Enter bookname");
				bookname=sc.next();
				System.out.println("Enter authorname");
				authorname=sc.next();
				System.out.println("Enter number of pages");
				pages=sc.nextInt();
				System.out.println("Enter price");
				price=sc.nextInt();
				pst.setString(1, bookname);
				pst.setString(2, authorname);
				pst.setInt(3, pages);
				pst.setInt(4,price);
				pst.executeUpdate();
				n--;
			}
			System.out.println("Data inserted");
			sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}

