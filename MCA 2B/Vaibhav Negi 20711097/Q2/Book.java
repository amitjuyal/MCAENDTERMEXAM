import java.sql.*;
import java.util.Scanner;

public class Book {
    static void multiinsert(Connection con) throws Exception{
        Scanner sc=new Scanner(System.in);
        String query="insert into bookdetails values (?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        boolean x=true;
        while(x) {
            System.out.println("Enter Book name");
            String name = sc.nextLine();
            System.out.println("Enter Author name");
            String aname = sc.nextLine();
            System.out.println("Enter Number of Pages");
            int page = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Book Price");
            int price= sc.nextInt();
            ps.setString(1, name);
            ps.setString(2, aname);
            ps.setInt(3, page);
            ps.setInt(4, price);
            int n = ps.executeUpdate();
            System.out.println((n == 0) ? "Not inserted" : "Inserted");
            System.out.println("Do you want to enter more values true or false");
            x = sc.nextBoolean();
        }
    }
        public static void main(String[] args) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "mca2021", "abcd");
                System.out.println("Connected");
                multiinsert(con);
            } catch (Exception e) {
                System.out.println("Exception is " + e);
            }
        }
    }

