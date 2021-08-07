
package com.database.testing;
import java.sql.*;
import java.util.Scanner;


public class TestPrepared {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8888/test","root","3333");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter book name :");
			String book_name=sc.nextLine();
			System.out.println("Enter author name :");
			String author_name=sc.nextLine();
			
			System.out.println("Enter number of pages:");
			int noOfPages=sc.nextInt();
			System.out.println("Enter Price:");
			double price=sc.nextDouble();
			
			String sql="insert into bookdetails values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, book_name);
			pst.setString(2, author_name);
			pst.setInt(3, noOfPages);
			pst.setDouble(4, price);
			
			int c=pst.executeUpdate();
			if(c!=0) {
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Data not inserted");
			}
			pst.close();
			
			con.close();
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		catch(ClassNotFoundException fof)
		{
			fof.printStackTrace();
		}

	}

}
