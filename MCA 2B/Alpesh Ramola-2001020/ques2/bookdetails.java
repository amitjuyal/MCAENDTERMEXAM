//Alpesh Ramola
//2001020

import java.sql.*;
import java.util.*;
public class Q2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
	System.out.println("Connected");
	  PreparedStatement pst=conn.prepareStatement("insert into bookdetails values (?,?,?,?)");
	  Scanner sc=new Scanner(System.in);
	    System.out.println("Enter book name");
	    String bname=sc.nextLine();
	    System.out.println("Enter author name");
	    String name=sc.nextLine();
	    System.out.println("Enter number of pages");
	    int nop=sc.nextInt();
        System.out.println("Enter price");
        int price = sc.nextInt();
	    pst.setString(1, bname);
	    pst.setString(2, name);
	    pst.setInt(3, nop);
        pst.setInt(4, price);
	    int x=pst.executeUpdate();
        pst.close();
        if(x!=0) {
        	System.out.println("Data inserted");
        }
        else {
        	System.out.println("Enter again");
        }
        pst=conn.prepareStatement("select * from bookdetails");
        ResultSet rs=pst.executeQuery();
        while(rs.next()) {
	    System.out.println("Book Name: "+rs.getString(1));
    	System.out.println("Author Name: "+rs.getString(2));
    	System.out.println("No of pages: "+rs.getInt(3));
        System.out.println("Price: "+rs.getInt(4));
        
		}
        //create procedure
        
    	//rs.first();
        conn.close();
}
		catch(Exception e) {
			e.printStackTrace();
		}
}
	}