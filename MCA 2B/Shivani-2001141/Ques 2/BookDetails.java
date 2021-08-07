import java.sql.*;
import java.util.Scanner;
public class BookDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Shivani_B_52";
		String psw="shivani123";
		Connection con=DriverManager.getConnection(url,usr,psw);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter number of records:");
		int n=sc.nextInt();
		
		PreparedStatement pst=con.prepareStatement("insert into bookdetails values(?,?,?,?)");
		
		String bname=null,aname=null;
		int noOfpages=0,price=0;
		
		while(n>0) {
			System.out.println("Enter Book name:");
			bname=sc.next();
			sc.nextLine();
			System.out.println("Enter Author name:");
			aname=sc.next();
			sc.nextLine();
			System.out.println("Enter Number of pages:");
			noOfpages=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter price:");
			price=sc.nextInt();
			sc.nextLine();
			pst.setString(1, bname);
			pst.setString(2, aname);
			pst.setInt(3, noOfpages);
			pst.setInt(4, price);
			pst.executeUpdate();
			n--;
		}
		System.out.println("Data Inserted Successfully...!!");
		
	}

}
