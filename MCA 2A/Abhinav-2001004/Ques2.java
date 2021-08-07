import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Ques2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/endterm";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url,user,password);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Book Name : ");
			String Bname=sc.next();
			System.out.print("Enter Auther Name : ");
			String Bauther=sc.next();
			System.out.print("Enter No. of pages : ");
			int Bpage=sc.nextInt();
			System.out.print("Enter price : ");
			int Bprice=sc.nextInt();
			String sql = "insert into bookdetails values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Bname);
			pst.setString(2, Bauther);
			pst.setInt(3,Bpage);
			pst.setInt(4, Bprice);
			int c= pst.executeUpdate();
			if(c!=0) {
				System.out.println("Data Inserted");
			}
			else {
				System.out.println("Not Inserted");
			}
			pst.close();  con.close();	
		}
		catch (SQLException i) 
		{i.printStackTrace();}
		catch(ClassNotFoundException e)
		{e.printStackTrace();}
	}
}
