package mcaend;
import java.sql.*;
import java.util.*;
public class ques2 {
	public static void main(String []args) {
	Scanner sc=new Scanner(System.in);
	try 
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","mca2021","asdf");
		PreparedStatement ps=con.prepareStatement("insert into BookDetails values(?,?,?,?)");
		System.out.println("Enter Book Name: ");
		String book=sc.next();
		System.out.println("Enter Author Name: ");
		String author=sc.next();
		System.out.println("Enter Pages of the Book: ");
		int pages=sc.nextInt();
		System.out.println("Enter Price of the Book: ");
		int price=sc.nextInt();
		ps.setString(1, book);
		ps.setString(2, author);
		ps.setInt(3, pages);
		ps.setInt(4, price);
	
		int x=ps.executeUpdate();
		if(x!=0)
		{
			System.out.println("Data Inserted...");	
		}
		else
		{
			System.out.println("Data not Inserted...");
		}
		System.out.println("");
		ps.close();
	}
	catch(SQLException s)
	{
		s.printStackTrace();
	}
}
}
