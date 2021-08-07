package first;
import java.sql.*;
import java.util.Scanner;


public class BookInfo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bookname: ");
		String bn=sc.nextLine();
		System.out.println("Enter Authorname: ");
		String an=sc.nextLine();
		System.out.println("Enter Number of Pages: ");
		int nop=sc.nextInt();
		System.out.println("Enter price: ");
		int pri=sc.nextInt();
				try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mca","root","ojas");
			String query="insert into bookdetails values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, bn);
			ps.setString(2, an);
			ps.setInt(3, nop);
			ps.setInt(4, pri);
			ps.close();
			con.close();  
			System.out.println("data inserted");
			
					
		}catch (Exception e) {
			
			throw new RuntimeException("Something went wrong");
		}

	}
	}


	


