package javapractical;
import java.sql.*;
import java.util.Scanner;

public class javaques2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:/mca";
			String user="root";
			String pswd="root";
			Connection con=DriverManager.getConnection(url,user,pswd);
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the no. of data inserted");
			int q=sc.nextInt();
			String bookname=null,author=null;
			int pages=0;
			double price=0.0;
			String sql="insert into bookdetails values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			while(q>0)
			{
				System.out.println("Enter the Bookname");
				bookname=sc.next();
				sc.nextLine();
				System.out.println("Enter the authorname");
				author=sc.next();
				System.out.println("Enter the no of pages");
				pages=sc.nextInt();
				System.out.println("Enter the price");
				price=sc.nextDouble();
			
			pst.setString(1, bookname);
			pst.setString(2, author);
			pst.setInt(3, pages);
			pst.setDouble(4, price);
			pst.executeUpdate();
			q--;
			}
			
				System.out.println("Data inserted");
			
			
			
			
		}
		catch(SQLException s)
		{
		}
		catch(ClassNotFoundException c)
		{
			
		}

}
}
