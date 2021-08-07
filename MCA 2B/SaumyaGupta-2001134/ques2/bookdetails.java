package firstprogram;
import java.sql.*;
import java.util.*;
public class bookdetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String usr="system";
			String pswd="abcd";
			Connection con=DriverManager.getConnection(url,usr,pswd);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter number of records");
			int n=sc.nextInt();
			PreparedStatement pst=con.prepareStatement("insert into bookdetails values(?,?,?,?)");
			String bookname=null,authorname=null;
			int pages=0,price=0;
			while(n>0)
			{
				System.out.println("Enter bookname");
				bookname=sc.next();
				System.out.println("Enter authorname");
				authorname=sc.next();
				System.out.println("Enter number of pages");
				pages=sc.nextInt();
				System.out.println("Enter price");
				price=sc.nextInt();
				pst.setString(1, bookname);
				pst.setString(2, authorname);
				pst.setInt(3, pages);
				pst.setInt(4,price);
				pst.executeUpdate();
				n--;
			}
			System.out.println("Data inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
