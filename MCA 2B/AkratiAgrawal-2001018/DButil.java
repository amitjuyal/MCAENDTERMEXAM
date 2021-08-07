
public class DButil {
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	public static Connection getConn(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kattu27");
			
		}
		catch(Exception e) {
		System.out.println(e);
		}
		return con;
	}
	public static ResultSet getData()throws Exception{
		con=getConn();
		pst=con.prepareStatement("select * from users");
		rs=pst.executeQuery();
		return rs;
	}
	public static int addData(UserBean b)throws Exception{
		int i=0;
		con=getConn();
		pst=con.prepareStatement("insert into users values(?,?,?,?)");
		pst.setString(1,b.getName());
        pst.setString(2, b.getPassword());
        pst.setInt(3, b.getAge());
        pst.setInt(4,b.getPhone());
        i=pst.executeUpdate();
        return i;
	}
}
