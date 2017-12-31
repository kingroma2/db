package com.java.database.clan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.clan.Clan;
import com.java.database.DB;
import com.java.database.DB_All;
import com.java.util.MyDate;
import com.java.util.Status;

public class DB_Clan implements DB_All{
	public int CLAN_NORMAL = Status.CLAN_NORMAL;
	public int CLAN_SPECIAL = Status.CLAN_SPECIAL;
	public int CLAN_ERROR = Status.CLAN_ERROR;
	public int CLAN_DELETE = Status.CLAN_DELETE;
	/*
	private int clan_number;
	private String chief_id;
	private int status;
	
	private int categori;
	private String title;
	private String textarea;
	
	private String memo; //包府磊 memo
	
	private String position;
	private String time;
	private Date clan_create_date;
	private String phone;
	 */
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
				+ "title varchar(200) default ' ',"
				+ "textarea varchar(500) default ' ',"
				+ "memo varchar(500) default ' ' ,"
				+ "position varchar(200) default ' ' ,"
				+ "time varchar(200) defalut ' ' ,"
				+ "clan_create_date varchar(20),"
				+ "phone varchar(20) default ' ' "
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
		Clan clan = null;
		int clan_number = (int)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from clan where clan_number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clan_number);
			clan = new Clan();
			result = pstmt.executeQuery();
			
			if(result.next()) {
				clan = null;
				clan = new Clan();
				
				clan.setClan_number(result.getInt("clan_number"));
				clan.setChief_id(result.getString("chief_id"));
				clan.setStatus(result.getInt("status"));
				
				clan.setCategori(result.getInt("categori"));
				clan.setTitle(result.getString("title"));
				clan.setTextarea(result.getString("textarea"));
				
				clan.setMemo(result.getString("memo"));
				clan.setPosition(result.getString("position"));
				clan.setTime(result.getString("time"));
			
				clan.setClan_create_date(new MyDate().changeStringToDate(result.getString("clan_create_date")));
				clan.setPhone(result.getString("phone"));
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clan;
	}
	
	@Override
	public boolean insert(Object obj) {
		Clan clan = (Clan)obj;
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "insert into clan("
				+ "chief_id,status,categori,"
				+ "title,textarea,memo,"
				+ "position,time,clan_create_date,"
				+ "phone"
				+ ") values("
				+ "?,?,?,"
				+ "?,?,?,"
				+ "?,?,?,"
				+ "?"
				+ ")";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, clan.getChief_id());
			pstmt.setInt(2, this.CLAN_NORMAL);
			pstmt.setInt(3, clan.getCategori());
			
			pstmt.setString(4, clan.getTitle());
			pstmt.setString(5, clan.getTextarea());
			pstmt.setString(6, clan.getMemo());
			
			pstmt.setString(7, clan.getPosition());
			pstmt.setString(8, clan.getTime());
			pstmt.setString(9, new MyDate().getCurrentDateByFormat());
			
			pstmt.setString(10, clan.getPhone());
			
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

	/*
	private int clan_number;
	private String chief_id;
	private int status;
	
	private int categori;
	private String title;
	private String textarea;
	
	private String memo; //包府磊 memo
	
	private String position;
	private String time;
	private Date clan_create_date;
	private String phone;
	 */
	
	//update clan set status = 2 where clan_number = 1
	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		Clan clan = (Clan)obj;
		PreparedStatement pstmt = null;
		String sql = "update clan set "
				+ "chief_id = ?,"
				+ "status = ?,"
				+ "title = ?,"
				+ "textarea = ?,"
				+ "memo = ?,"
				+ "position = ?,"
				+ "time = ?,"
				+ "phone = ? where clan_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, clan.getChief_id());
			pstmt.setInt(2, clan.getStatus());
			pstmt.setString(3,clan.getTitle());
			pstmt.setString(4, clan.getTextarea());
			pstmt.setString(5, clan.getMemo());
			pstmt.setString(6, clan.getPosition());
			pstmt.setString(7, clan.getTime());
			pstmt.setString(8, clan.getPhone());
			
			pstmt.setInt(9, clan.getClan_number());
			
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
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		Clan clan = (Clan)obj;
		PreparedStatement pstmt = null;
		String sql = "update clan set "
				+ ""
				+ "status = ?"
				+ " where clan_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, this.CLAN_DELETE);
			
			pstmt.setInt(2, clan.getClan_number());
			
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
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
