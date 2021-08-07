package question2;
import java.sql.*;
import java.util.Scanner;
public class Question2
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url="jdbc:oracle:thin:@localhost:1521:XE";
        String usr="mca";
        String psw="1111";
        Connection con=DriverManager.getConnection(url,usr,psw);
        System.out.println("enter no of records to be inserted: ");
        Scanner sc=new Scanner(System.in);
        int no=sc.nextInt();
        String bookname=null;
        String author=null;
        int pages;
        int price;
         PreparedStatement pt=con.prepareStatement("insert into bookdetails values(?,?,?,?)");
        while(no>0)
        {
            System.out.println("enter book name: ");
            bookname=sc.next();
            System.out.println("enter author name: ");
            author=sc.next();
            System.out.println("enter number of pages: ");
            pages=sc.nextInt();
            System.out.println("Enter price: ");
            price=sc.nextInt();
            pt.setString(1, bookname);
            pt.setString(2, author);
            pt.setInt(3, pages);
            pt.setInt(4, price);
            pt.executeUpdate();
            no--;
        }
        con.close();
    }
}