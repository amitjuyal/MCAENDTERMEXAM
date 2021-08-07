package com.deepak;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class book {
	public static void main(String[] args) {
		String dbURL = "jdbc:oracle:thin:@localhost:1521:";
		String username = "system";
		String password = "abcd";
		 try{	
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	    	  Connection con= DriverManager.getConnection(dbURL,username,password);
	    	  
	    	  Scanner sc = new Scanner(System.in);

	    	  System.out.print("bookname: ");
	    	  String Bn = sc.nextLine();

	    	  System.out.print("author name: ");
	    	  String An = sc.nextLine();

	    	  System.out.print("number of pages: ");
	    	  int Pn = sc.nextInt();
	    	  
	    	  System.out.print("price : ");
	    	  int Pr = sc.nextInt();
	    	  
	    	  
	    	  String sql = "insert into bookdetails values (?, ?, ?,?)";

	    	  PreparedStatement myStmt = con.prepareStatement(sql);
	    		
	    		myStmt.setString(1, Bn);
	    		myStmt.setString(2, An);
	    		myStmt.setInt(3, Pn);
	    		myStmt.setInt(4, Pr);
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
