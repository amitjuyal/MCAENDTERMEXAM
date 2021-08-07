//Mayur Thapliyal
//20711087
import java.sql.*;
import java.util.*;
public class Book
{
	public static void main(String[] args)
	{
	
	try
		{
		   
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Mayur","root", "root");
		PreparedStatement ps =con.prepareStatement("insert into book values(?,?,?,?)");   
		Scanner sc =new Scanner(System.in);	
		
		do	{  
			System.out.println("enter bookname:");  
			String bookname=sc.nextLine();  
			System.out.println("enter authorname:");  
			String authorname=sc.nextLine();  
			System.out.println("enter no. of pages:");  
			int no_page=sc.nextInt();  
			System.out.println("Price");  
			int price=sc.nextInt();  
  
			ps.setString(1,bookname);  
			ps.setString(2,authorname);
  			ps.setInt(3,no_page); 
			ps.setInt(4,price);  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
  
			System.out.println("Do you want to continue: y/n");  
			String s=sc.nextLine();  
			if(s.startsWith("n")){  
			break;  
			
			}}while(true);  
	   	}
	catch (SQLException e) { System.out.println(e);}
	con.close();
	}
}