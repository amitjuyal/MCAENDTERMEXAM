import java.sql.*;
import java.util.Scanner;

public class bookdetails {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1512:XE";
			String usr="JDBC";
			String pswd="jdbc
			Connection con=DriverManager.getConnection(url,usr,pwd);
			Scanner sc=new Scanner(System.in);
			PreparedStatement pst=con.prepareStatement("insert into bookdetails values(?,?,?,?)");
			System.out.println("Enter number of records you want to enter: ");
			int n=sc.nextInt();
			String bookname=null,authorname=null;
			int pages=0,price=0;
			while(n>0)
			{
				System.out.println("Enter Book Name: ");
				bookname=sc.next();
				System.out.println("Enter Author Name: ");
				authorname=sc.next();
				sc.nextLine();
				System.out.println("Enter number of pages: ");
				pages=sc.nextInt();
				System.out.println("Enter Book Price:");
				price=sc.nextInt();
				pst.setString(1, bookname);
				pst.setString(2, authorname);
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