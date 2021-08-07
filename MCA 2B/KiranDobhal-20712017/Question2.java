package endterm;

import java.sql.*;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String usr="MCA2";
			String pswd="mca123";
			Connection con=DriverManager.getConnection(url,usr,pswd);
			Scanner sc=new Scanner(System.in);
			PreparedStatement pst=con.prepareStatement("insert into BookDetails values(?,?,?,?)");
			System.out.println("Enter number of records you want to enter: ");
			int n=sc.nextInt();
			String bname=null,aname=null;
			int pages=0,price=0;
			while(n>0)
			{
				System.out.println("Enter Name of the Book: ");
				bname=sc.next();
				System.out.println("Enter Author Name: ");
				aname=sc.next();
				sc.nextLine();
				System.out.println("Enter number of pages: ");
				pages=sc.nextInt();
				System.out.println("Enter Price of The Book:");
				price=sc.nextInt();
				pst.setString(1, bname);
				pst.setString(2, aname);
				pst.setInt(3, pages);
				pst.setInt(4,price);
				pst.executeUpdate();
				n--;
			}			
			System.out.println("Data inserted");
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
