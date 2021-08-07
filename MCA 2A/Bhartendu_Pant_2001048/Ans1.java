package web_login;
import java.sql.*;
public class dbutil {
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	public static Connection getConn()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:8888/endterm";
			String user="root";
			String pswrd="3333";
			
			 con=DriverManager.getConnection(url,user,pswrd);
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return con;
	}
	public static ResultSet getData() throws Exception
	{
		con=getConn();
		pst=con.prepareStatement("select * from userdata");
		rs=pst.executeQuery(); 
		return rs;
	}
public static int addData(userbean b) throws Exception
{
	int i=0;
	con=getConn();
	pst=con.prepareStatement("insert into userdata values(?,?)");
	pst.setString(1, b.getUsername());
	pst.setString(2, b.getPassword());
	i=pst.executeUpdate(); 
	return i;
}


}
