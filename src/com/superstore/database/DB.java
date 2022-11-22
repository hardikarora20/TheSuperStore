package com.superstore.database;
import java.sql.*;

public class DB {
	public static Connection makeConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String path="jdbc:mysql://localhost:3306/shop";
			String username="root";
			String password="bhopal123";
			con=DriverManager.getConnection(path,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
