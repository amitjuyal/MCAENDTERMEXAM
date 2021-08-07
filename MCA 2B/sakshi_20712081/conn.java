import java.sql.*;

public class conn {
    public static boolean checkUser(String email,String pass)
    {
        boolean st =false;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abcd");
            PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}