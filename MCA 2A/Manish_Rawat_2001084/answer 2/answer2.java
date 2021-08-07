package com.javaendterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Answer2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Book name:");
		String bookname = sc.nextLine();

		System.out.println("Enter the price:");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter the no of pages:");
		int page = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter the Author name:");
		String authorname = sc.nextLine();

		Book obj = new Book();
		obj.setBookName(bookname);
		obj.setBookPrice(price);
		obj.setNoOfPages(page);
		obj.setAuthorName(authorname);

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");

			PreparedStatement stmt = con.prepareStatement("insert into bookdetails values(?,?,?,?)");
			
			stmt.setString(1, obj.getBookName());
			stmt.setString(2, obj.getBookName());
			stmt.setInt(3, obj.getBookPrice());
			stmt.setInt(4,obj.getNoOfPages());

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}