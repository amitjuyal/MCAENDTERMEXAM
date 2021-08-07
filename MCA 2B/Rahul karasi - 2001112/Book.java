package endPractical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Book {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
			System.out.println("Connected");
			  PreparedStatement pst=conn.prepareStatement("insert into bookdetails values (?,?,?,?)");
			  Scanner sc=new Scanner(System.in);
			    System.out.println("Enter book name");
			    String bname=sc.nextLine();
			    System.out.println("Enter author name");
			    String aname=sc.nextLine();
			    System.out.println("Enter number of pages");
			    int npages=sc.nextInt();
		        System.out.println("Enter price");
		        int price = sc.nextInt();
			    pst.setString(1, bname);
			    pst.setString(2, aname);
			    pst.setInt(3, npages);
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
		       
		        conn.close();
		}
				catch(Exception e) {
					e.printStackTrace();
				}
}
}
