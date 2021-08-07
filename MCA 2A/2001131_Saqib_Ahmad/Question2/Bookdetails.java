import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.Scanner;
import java.util.*;  
public class Scan throws Exception{  
public static void main(String args[]){  

                  Connection connection = null; 
                  PreparedStatement pstatement = null; 
                  Scanner scanner = null; 
           
                  try { 
                   
                      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
                      connection = DriverManager.getConnection("jdbc:mysql://localhost"); 
                      if (connection != null) 
                      pstatement = connection.prepareStatement("insert into Book values(?,?,?,?)"); 
                      if (pstatement != null) {
                              System.out.println("Enter Book Details"); 
                              System.out.println("Book name : "); 
                              String bookname = scanner.next(); 
                              System.out.println("Enter Authur Name : "); 
                              String authurName = scanner.next(); 
                              System.out.println("Enter number of pages : "); 
                              int NoOfPages = scanner.nextInt(); 
                              System.out.println("Enter price : "); 
                              int price = scanner.nextInt(); 
                              pstatement.setString(1, bookname); 
                              pstatement.setString(2, authurName); 
                              pstatement.setInt(3, NoOfPages); 
                              pstatement.setInt(4, price); 
                              int result = pstatement.executeUpdate(); 
                              if (result == 0) { 
                                  System.out.println("Book details: are not inserted"); 
                              } else { 
                                  System.out.println(result + " records(s) are  inserted"); 
                              } 
                      } 
                   }
          }  
}  
