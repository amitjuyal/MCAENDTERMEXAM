package java1;
import java.sql.*;
public class j1
{

	public static void main(String[] args) 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver"); 
		String url="jdbc:mysql://localhost:3306/test"; 
		String usr="root";
		String pswrd="root";
		Connection con=DriverManager.getConnection(url,usr,pswrd); 
		Statement st=con.createStatement();
		String sql="insert into stud values('JOSHI',23)"; 
		int c=st.executeUpdate(sql);
		if(c!=0)
		{
			System.out.println("Data inserted");
		}
		else
		{
			System.out.println("Not inserted");
		}
		}
		catch(SQLException s)
		{
		s.printStackTrace();
		}
		catch(ClassNotFoundException c)
		{
		c.printStackTrace();
		}
	}

}
 