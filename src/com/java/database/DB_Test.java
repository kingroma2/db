package com.java.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Test {
	DB db = new DB();
	public DB_Test() {
		
		db.start();
	}
	public void test() {
		
		try {
			Connection conn = db.getConn();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from test");
			
			while(result.next()) {
				System.out.println(result.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		end();
	}
	public void end() {
		db.start();
	}
}
