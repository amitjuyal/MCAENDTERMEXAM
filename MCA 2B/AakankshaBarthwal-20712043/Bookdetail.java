package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Bookdetail
    {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="system";
		String pswd="orcl";
		Connection con=DriverManager.getConnection(url,usr,pswd);
		Scanner s=new Scanner(System.in);
		PreparedStatement preparedst=con.prepareStatement("insert into bookdetails values(?,?,?,?)");
		System.out.println("Enter number of records you want to enter: ");
		int n=sc.nextInt();
		String bookname=null,authorname=null;
		int pages=0,price=0;
		while(n>0)
		{
			System.out.println("Enter Book Name: ");
			bookname=sc.next();
			System.out.println("Enter Author Name: ");
			authorname=sc.next();
			sc.nextLine();
			System.out.println("Enter number of pages: ");
			pages=sc.nextInt();
			System.out.println("Enter Book Price:");
			price=sc.nextInt();
			preparedst.setString(1, bookname);
			preparedst.setString(2, authorname);
			preparedst.setInt(3, pages);
			preparedst.setInt(4,price);
			preparedst.executeUpdate();
			n--;
		}			
		System.out.println("Data inserted");
		preparedst.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
    }
