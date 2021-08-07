package com.Tanya.Question1;
import java.util.*;
import java.sql.*;
public class DataInsert {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tanya", "Oracle");
		 Scanner sc = new Scanner(System.in);
	        System.out.println("enter no of records to be inserted: ");
	        int n = sc.nextInt();

	        while (n > 0) {
	            System.out.println("Enter Book Name :");
	            String nm = sc.next();
	            System.out.println("Enter Author Name:");
	            String aunm = sc.next();
	            System.out.println("Enter Number Of pages:");
	            int nop = sc.nextInt();
	            System.out.println("Enter Book Price:");
	            int price = sc.nextInt();

	            
	            String sql = "insert into bookdetails values(?,?,?,?)";

	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, nm);
	            pst.setString(2, aunm);
	            pst.setInt(3, nop);
	            pst.setInt(4, price);
	            int c = pst.executeUpdate();
	            if (c != 0) {
	                System.out.println("Data Inserted");
	            } else {
	                System.out.println("Data Not Inserted");
	            }
	            n--;
	        }
	    }
	
	}