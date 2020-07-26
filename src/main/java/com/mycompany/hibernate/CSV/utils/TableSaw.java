package com.mycompany.hibernate.CSV.utils;

import java.io.IOException;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.io.csv.CsvReader;

public class TableSaw {
	
	public static void main(String[] args) throws IOException {
		CsvReadOptions.Builder builder = CsvReadOptions.builder("c:\\source\\bookmonth1.csv")
				.separator(',')
				.header(true)
				.dateFormat("yyyMM");
		
		CsvReadOptions options = builder.build();
		CsvReader reader = new CsvReader();
		System.out.println(reader.printColumnTypes(options));
//		ColumnType[] types = {LOCAL_DATE, INTEGER, FLOAT, FLOAT, CATEGORY};
		Table t1 = Table.read().usingOptions(options);
		System.out.println(t1.structure());
		
	}

}
