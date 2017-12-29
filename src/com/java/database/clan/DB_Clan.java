package com.java.database.clan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.util.Status;

public class DB_Clan implements DB_All{
	public int CLAN_NORMAL = Status.CLAN_NORMAL;
	public int CLAN_SPECIAL = Status.CLAN_SPECIAL;
	public int CLAN_ERROR = Status.CLAN_ERROR;
	public int CLAN_DELETE = Status.CLAN_DELETE;
	
	DB db = null;
	Connection conn = null;
	@Override
	public void start() {
		// TODO Auto-generated method stub
		db = new DB();
		db.start();
		conn = db.getConn();
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		db.end();
	}
	/*
	private int clan_number;
	private String chief_id;
	private int status;
	
	private int categori;
	private String title;
	private String textarea;
	private String memo; //°ü¸®ÀÚ memo
	
	private String position;
	private String time;
	private Date account_date;
	private Date clan_create_date;
	private String phone;
	 */
	
	//AUTO_INCREMENT 
	@Override
	public boolean create_table() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "create table clan ("
				+ "clan_number int AUTO_INCREMENT primary key,"
				+ "chief_id varchar(20),"
				+ "status int default "+this.CLAN_NORMAL+","
				+ "categori int not null ,"
				+ "title varchar(200),"
				+ "textarea varchar(500),"
				+ "memo varchar(500),"
				+ "position varchar(200),"
				+ "time varchar(200),"
				+ "account_date varchar(20),"
				+ "clan_create_date varchar(20),"
				+ "phone varchar(20)"
				+ ")";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}

	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
