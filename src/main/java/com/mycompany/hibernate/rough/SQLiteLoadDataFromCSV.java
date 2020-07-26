package com.mycompany.hibernate.rough;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteLoadDataFromCSV {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = SQLiteJDBC.getSQLiteConnection("SQLiteTest1.db");
		Statement stmt = connection.createStatement();
		/*
		 * stmt.
		 * execute("CREATE TABLE SCHOOL_CODES(ID INTEGER, SCHOOLCODE VARCHAR2(20), SCHOOLNAME VARCHAR2(40), "
		 * +
		 * "ADDRESS VARCHAR2(50), CITY VARCHAR2(20), STATECODE VARCHAR2(4), ZIPCODE INTEGER, "
		 * + "PROVINCE VARCHAR2(10), COUNTRY VARCHAR2(20), POSTALCODE VARCHAR2(20)");
		 */

//		stmt.execute(
//				"CREATE TABLE BOOKMONTH(LOANID INTEGER, ACQUISITION_DATE VARCHAR(10), IN_BASE VARCHAR(1), MI_COMPANY VARCHAR(3), PRINCIPLE_BALANCE VARCHAR(20), PRINCIPLE_BALANCE_2 VARCHAR(20))");

//		stmt.execute("DROP TABLE BOOKMONTH");
		
		File file = new File("c:\\source\\bookmonth1.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = null;
		List<String[]> list = new ArrayList<String[]>();
		while ((line = br.readLine()) != null) {

			list.add(line.split(","));

		}
		br.close();

//		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO BOOKMONTH VALUES(?,?,?,?,?,?);");
//
//		for (int i = 1; i <= list.size() - 1; i++) {
//			for (int j = 0; j <= list.get(i).length - 1; j++) {
//				pstmt.setString(j + 1, list.get(i)[j]);
//
//			}
//		}
//		stmt.execute("INSERT INTO BOOKMONTH VALUES(123,'abc',233,'asdfa','aaf','afddaf');");
		ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKMONTH;");
		ResultSetMetaData rsmeta = rs.getMetaData();
//		System.out.print(rsmeta.getColumnName(1));
		for(int i=1; i<=rsmeta.getColumnCount(); i++) {
			System.out.print(rsmeta.getColumnName(i)+" ");
		}
System.out.println();
		while(rs.next()) {
			for(int i=1; i<=rsmeta.getColumnCount(); i++) {
			System.out.print(rs.getString(i)+ " ");
//			System.out.println(rs.getInt(1));
			}
		}
	}
	

}
