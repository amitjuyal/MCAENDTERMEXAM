import java.sql.*;  
import java.io.*;  
class Demo{  
public static void main(String args[])throws Exception{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
  
PreparedStatement ps=con.prepareStatement("insert into bookdetails values(?,?,?)");  
  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
do{  
System.out.println("enter Bookname:");  
String name=br.readLine();
System.out.println("enter Authorname:");  
String name=br.readLine();
System.out.println("enter pages:");  
int id=Integer.parseInt(br.readLine());  
System.out.println("enter price:");  
int id=Integer.parseInt(br.readLine());

ps.setString(1,Bookname);
ps.setString(2,Authorname);
ps.setInt(3,pages);    
ps.setInt(4,price); 
 
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  
System.out.println("Do you want to continue: y/n");  
String s=br.readLine();  
if(s.startsWith("n")){  
break;  
}  
}while(true);  
con.close();  
}}  