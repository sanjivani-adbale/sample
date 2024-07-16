package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {

		int id,age;
		String name;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter students id : ");
		id = sc.nextInt();
		System.out.println("Enter students name : ");
		name = sc.next();
		System.out.println("Enter students age : ");
		age = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			
			String query = "insert into students values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			pstmt.executeUpdate();
			
			System.out.println("Record Added Successfully...");
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
