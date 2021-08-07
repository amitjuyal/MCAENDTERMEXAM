//Anjali Rana MCA A
import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/BookDetails";
        String user="root";
        String password="Qwerty123@";

        Connection conn =DriverManager.getConnection(url, user, password);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the BookName:");
        String name=sc.nextLine();
        System.out.println("Enter the AuthorName:");
        String authname=sc.nextLine();
        System.out.println("Enter the Number Of Pages:");
        long numofpages=sc.nextLong();
        System.out.println("Enter the Price of the book::");
        long price=sc.nextLong();


        String query="insert into bookdetails values(?,?,?,?)";
        PreparedStatement pstmt=conn.prepareStatement(query);
        pstmt.setString(1,name);
        pstmt.setString(2, authname);
        pstmt.setLong(3, numofpages);
        pstmt.setLong(4, price);
        
        System.out.println("Recorded Successfully");
        conn.close();
}catch(Exception e){
    System.out.println(e);
}
}
}