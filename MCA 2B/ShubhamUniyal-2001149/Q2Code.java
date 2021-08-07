package com.database.test;
import java.sql.*;
import java.util.Scanner;
public class endterm {

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost/java";
String user="root";
String password="12345";
Connection con=DriverManager.getConnection(url,user,password);

System.out.println("Enter Book Name: ");
String bn=sc.nextLine();
System.out.println("Enter Author Name: ");
String au=sc.nextLine();
System.out.println("Enter Number of Pages: ");
int np=sc.nextInt();
System.out.print("Enter Price: ");
int pr=sc.nextInt();

Statement st=con.createStatement();
String sql="insert into bookdetails values(?,?,?,?)";

PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1, bn);
pst.setString(2, au);
pst.setInt(3, np);
pst.setInt(4, pr);

int c=pst.executeUpdate();
if(c!=0)
{
System.out.println("Data Inserted");
}
else
{
System.out.println("Data Not Inserted");
}
}
catch(SQLException s)
{
s.printStackTrace();
}
catch(ClassNotFoundException c)
{
c.printStackTrace();
}

}

}