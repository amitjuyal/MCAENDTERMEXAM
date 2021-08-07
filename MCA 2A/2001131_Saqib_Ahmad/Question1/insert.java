import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:mysql://localhost";
   static final String USER = "guest";
   static final String PASS = "guest123";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO Userdata VALUES ('Zara',1234)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Userdata VALUES ('Mahnaz',5464)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Userdata VALUES ('Zaid',7430)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Userdata VALUES('Sumit',6328)";
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}

