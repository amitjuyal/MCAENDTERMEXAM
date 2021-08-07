import java.sql.*;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class Jav {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		  
		System.out.println("Enter bookname : ");
		  String bname = in.nextLine();
		  System.out.println("Enter Author name : ");
		  String aname = in.nextLine();
		  System.out.println("Enter no of page : ");
		  int page = in.nextInt();
		  System.out.println("Enter price : ");
		  int price = in.nextInt();
		
		  try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");			 
			   
			   String s = "insert into student values (?,?,?,?)";
			   PreparedStatement pt = con.prepareStatement("s");
			   
			   pt.setString(1, bname);
			   pt.setString(2, aname);
			   pt.setInt(3, page);
			   pt.setInt(4, price);
			   
			   con.close();
			  } catch (Exception e) {
			   System.out.println("Connection problem");
			   
			   
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		  
		  

	}
	
	

}
