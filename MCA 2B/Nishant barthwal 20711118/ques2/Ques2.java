import java.sql.*;
import java.util.*;
public class Ques2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/book","root@local","1234");
	System.out.println("Connected");
	  PreparedStatement pst=conn.prepareStatement("insert into bookdetail values (?,?,?,?)");
	  Scanner sc=new Scanner(System.in);
	    System.out.println("Enter book name");
	    String Bookname=sc.nextLine();
	    System.out.println("Enter author name");
	    String Authorname=sc.nextLine();
	    System.out.println("Enter number of pages");
	    int Numberofpages=sc.nextInt();
        System.out.println("Enter price");
        int Price = sc.nextInt();
	    pst.setString(1, Bookname);
	    pst.setString(2, Authorname);
	    pst.setInt(3, Numberofpages);
        pst.setInt(4, Price);
	    int x=pst.executeUpdate();
        pst.close();
        if(x!=0) {
        	System.out.println("Data inserted");
        }
        else {
        	System.out.println("Enter again");
        }
        pst=conn.prepareStatement("select * from bookdetail");
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
