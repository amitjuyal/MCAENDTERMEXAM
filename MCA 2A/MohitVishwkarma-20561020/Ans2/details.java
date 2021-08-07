import java.sql.*;
import java.util.Scanner;

public class Bookdetails 
{
	public static void main(String[] args) 
	{
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mca","root","root");
		
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter name:");
		 String name=sc.next();
		 System.out.println("Enter author:");
		 String author=sc.next();
		 System.out.println("Enter pages:");
		 int pages=sc.nextInt();
		 System.out.println("Enter price:");
		 int price=sc.nextInt();
		 PreparedStatement stmt=con.prepareStatement("insert into details values(?,?,?,?)");  
		stmt.setString(1,name);
		stmt.setString(2,author);
		stmt.setInt(3,pages);
		stmt.setInt(4,price);
		int c=stmt.executeUpdate();
		if(c!=0)
		{
			System.out.println("Data Inserted"+c);
		}
		else
		{
			System.out.println("Data Not Inserted");
		}
		stmt.close();
		con.close();
	
}
	catch(ClassNotFoundException e)
	{
		System.out.println(e);
	}
	catch(SQLException z)
	{
		System.out.println(z);
	}
}
}