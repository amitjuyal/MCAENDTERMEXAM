import java.sql.*;
import java.util.*;
class end{
	public static void main (String args[]){
	
	Scanner sc=new Scanner(System.in);
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MCA2","mca123");
			PreparedStatement pst=con.prepareStatement("insert into BookDetails values(?,?,?,?)");
			System.out.println("Enter Book Name: ");
			String bname=sc.next();
			System.out.println("Enter Author Name: ");
			String aname=sc.next();
			System.out.println("Enter Pages of the Book: ");
			int pages=sc.nextInt();
			System.out.println("Enter Price of the Book: ");
			int price=sc.nextInt();
			pst.setString(1, bname);
			pst.setString(2, aname);
			pst.setInt(3, pages);
			pst.setInt(3, price);
		
			int x=pst.executeUpdate();
			if(x!=0)
			{
				System.out.println("Data Inserted...");	
			}
			else
			{
				System.out.println("Data not Inserted...");
			}
			System.out.println("");
			pst.close();
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
	}
}