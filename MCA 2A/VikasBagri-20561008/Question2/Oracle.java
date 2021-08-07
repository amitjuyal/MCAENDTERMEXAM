import java.sql.*;
import java.io.*;
import java.util.Scanner;
class Oracle
{
	public static void main(String []g)
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mca2020","vikas");
	
		//String  t1="Klara And The Sun";
		//String t2="Kazumi Ishguaro";
		//int t3= 300;
		//int t4= 550;

		Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		s.executeUpdate("create table bookdetails(bookname varchar2(20),authorname varchar2(20),numberofpages number,price number)" );
		s.close();
		PreparedStatement ps=c.prepareStatement("insert into bookdetails values(?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book name");
		String t1 = sc.nextLine();
		System.out.println("Enter Author name");
		String t2 = sc.nextLine();
		System.out.println("Enter number of pages");
		int t3 = sc.nextInt();
		System.out.println("Enter Book price");
		int t4 = sc.nextInt();
		ps.setString(1,t1);
		ps.setString(2,t2);
		ps.setInt(3,t3);
		ps.setInt(4,t4);

		ps.executeUpdate();
		ps.close();
		ps=c.prepareStatement("select * from bookdetails");
		ResultSet result1=ps.executeQuery();
		System.out.println("\nBook Details are --");
		while(result1.next())
			{
				System.out.println( result1.getString(1));
				System.out.println( result1.getString(2));
				System.out.println( result1.getInt(3));
				System.out.println( result1.getInt(4));
			}
		}	
		catch(Exception i)
		{
			System.out.println(i);
		}
	}
}
















