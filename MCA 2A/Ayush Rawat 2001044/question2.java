import java.sql.*;
import java.util.Scanner;
class Main{  
	public static void main(String args[]){  
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Author name");
		String a_name = sc.nextLine();
		System.out.println("Enter Book name");
		String b_name = sc.nextLine();
		System.out.println("Number of pages");
		int pages = sc.nextInt();
		System.out.println("Book price");
		int price = sc.nextInt();
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
  
			Connection con=DriverManager.getConnection("localhost","root","pass");  
  
			PreparedStatement statement=con.prepareStatement("insert into bookdetails values(?,?,?,?)");  
			statement.setString(1,b_name);
			statement.setString(2,a_name);
			statement.setInt(3,pages);
			statement.setInt(4,price);
  
			int i=statement.executeUpdate();  
			System.out.println(i+" records inserted");  
  
			con.close();  
  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
  
	}  
}  