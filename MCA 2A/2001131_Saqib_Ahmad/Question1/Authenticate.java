import java.sql.*;  
  
public class Login {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from Userdata where username=? and password=?");  
ps.setString(1,username);  
ps.setString(2,password);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
response.sendRedirect("Welcome.html");  

}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  
