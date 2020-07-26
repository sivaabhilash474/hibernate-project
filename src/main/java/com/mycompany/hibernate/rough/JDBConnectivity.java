package com.mycompany.hibernate.rough;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnectivity {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:hr/HR@localhost:1521/orclpdb");
		
//		String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=ORCLPDB)))";
		
//		Connection con=DriverManager.getConnection(dbURL, "HR","HR");  
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from regions");
		ResultSetMetaData meta = rs.getMetaData();
		int numberOfColumns = meta.getColumnCount();
		
		for(int i=1; i<=numberOfColumns; i++) {
		
		System.out.println(meta.getColumnName(i));
		}
		
		System.out.println("================================================================================");
		
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	
}
