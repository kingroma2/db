package com.java.database.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.user.User_Clan;

public class DB_User_Clan implements DB_All{

	/*
	 * private int clan;
	 * private String user_id;
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

	@Override
	public boolean create_table() {
		// TODO Auto-generated method stub
		Statement stmt = null;
		String sql = "create table user_clan ( clan_number int , user_id varchar(20) )";
		try {
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	@Override
	public Object select(Object obj) {
		ArrayList<User_Clan> clans = new ArrayList<User_Clan>();
		String id = (String)obj;
		
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String sql = "select * from user_clan where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			User_Clan clan = null;

			while(result.next()) {
				clan = null;
				clan = new User_Clan();
				
				clan.setClan_number(result.getInt("clan_number"));
				clan.setUser_id(result.getString("user_id"));
				clans.add(clan);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(result!=null)
					result.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return clans;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		User_Clan user_clan = (User_Clan)obj;
		PreparedStatement pstmt = null;
		String sql = "insert into user_clan (user_id , clan_number) value (?,?)";
		try {
			String user_id = user_clan.getUser_id();
			int clan_number = user_clan.getClan_number();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, clan_number);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		//필요가 없겟구나 .
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		User_Clan clan = (User_Clan)obj;
		String user_id = clan.getUser_id();
		int clan_number = clan.getClan_number();
		String sql = "delete from user_clan where user_id = ? and clan_number = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setInt(2, clan_number);
			
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
		
		return false;
	}

	@Override
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		/*
		 * private int clan;
		 * private String user_id;
		 */
		User_Clan clan = (User_Clan)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from user_clan where clan_number = ? and user_id = ?";
		boolean return_value = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clan.getClan_number());
			pstmt.setString(2, clan.getUser_id());
			result = pstmt.executeQuery();
			
			if(result.next())
				return_value = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return return_value;
	}

}
