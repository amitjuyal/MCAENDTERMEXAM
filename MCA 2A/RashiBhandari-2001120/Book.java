 import java.sql.*;
 import java.util.*;

public class Book {

	 static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	   static final String user = "mca";
	   static final String pass = "mca";

	   public static void main(String[] args) {
	    
	      try
	       {	
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	    	  Connection con= DriverManager.getConnection(url,user,pass);
	    	  
	    	  Scanner sc = new Scanner(System.in);

	    	  System.out.print("bookname: ");
	    	  String Bname= sc.nextLine();

	    	  System.out.print("author name: ");
	    	  String Aname = sc.nextLine();

	    	  System.out.print("number of pages: ");
	    	  int Pn = sc.nextInt();
	    	  
	    	  System.out.print("price : ");
	    	  int Price = sc.nextInt();
	    	  
	    	  
	    	  String sql = "insert into bookdetails values (?, ?, ?,?)";

	    	  PreparedStatement myStmt = con.prepareStatement(sql);
	    		
	    		myStmt.setString(1, Bname);
	    		myStmt.setString(2, Aname);
	    		myStmt.setInt(3, Pn);
	    		myStmt.setInt(4, Price);
	    		myStmt.executeUpdate();
	    	  sc.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	      catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } 
	   }
		

	}


