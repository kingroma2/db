package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private Connection conn = null;
	private String db_jdbc = "com.mysql.jdbc.Driver";
	private String db_url = "jdbc:mysql://127.0.0.1:3306/mymatch";
	private String db_id = "root";
	private String db_pw = "1234";
	
	public DB() {
		
	}
	public void start(){
        try {
            Class.forName(db_jdbc);
            conn = DriverManager.getConnection(db_url,db_id,db_pw);
            System.out.println("데이터베이스 접속 성공 [[ START ]]");

        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
	public void end(){
		try {
            if (conn != null) conn.close();
            conn = null;
            System.out.println("데이터베이스 종료 완료 [[ END ]]");
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
	}
	
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public String getDb_jdbc() {
		return db_jdbc;
	}
	public void setDb_jdbc(String db_jdbc) {
		this.db_jdbc = db_jdbc;
	}
	public String getDb_url() {
		return db_url;
	}
	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}
	public String getDb_id() {
		return db_id;
	}
	public void setDb_id(String db_id) {
		this.db_id = db_id;
	}
	public String getDb_pw() {
		return db_pw;
	}
	public void setDb_pw(String db_pw) {
		this.db_pw = db_pw;
	}
	
	
}
