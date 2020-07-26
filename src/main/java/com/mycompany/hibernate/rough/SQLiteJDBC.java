package com.mycompany.hibernate.rough;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
	static Connection connection;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:SQLiteTest1.db");
		Statement stmt = conn.createStatement();
//		stmt.execute("DROP TABLE USER");
//		ResultSet rs = stmt.executeQuery("SELECT NAME FROM SQLITE_MASTER WHERE TYPE='TABLE' AND NAME = 'USER'");
//		stmt.execute("INSERT INTO USER VALUES(2, 'SIVA','ABHILASH')");
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER");

//		if(!rs.next()) {
//			System.out.println("Creating table.....");
//		 stmt.execute("CREATE TABLE USER(ID INTEGER, FNAME VARCHAR(60), LNAME VARCHAR(60), PRIMARY KEY(ID));");
//		 stmt.execute("INSERT INTO USER VALUES(1, 'SIVA','ABHILASH')");
////		 stmt.exe
//		} else {
//			while(rs.next()) {
//				System.out.println(rs.getInt(1));
//			}
//		}
		
		ResultSetMetaData meta = rs.getMetaData();
		
		for(int i=1; i<=meta.getColumnCount(); i++) {
			System.out.print(meta.getColumnName(i)+ " ");
		}
		System.out.println();
	
		while(rs.next()) {
			
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		
		
		
	}
	
	public static Connection getSQLiteConnection(String databaseName) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:"+databaseName);
			
		return connection;
	}
	
	
}
