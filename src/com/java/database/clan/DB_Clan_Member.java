package com.java.database.clan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.clan.Clan_Member;
import com.java.database.DB;
import com.java.database.DB_All;

public class DB_Clan_Member implements DB_All{
	
	/*
	 * private String user_id;
	 * private int clan_number;
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
		
		PreparedStatement pstmt = null;
		String sql = "create table clan_member (user_id varchar(20),clan_number int)";
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
		
		return false;
	}

	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		ArrayList<Clan_Member> members = null;
		Clan_Member member = null;
		int clan_number = (int)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from clan_member where clan_number = ?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, clan_number);
			
			result = pstmt.executeQuery();
			
			members = new ArrayList<Clan_Member>();
			
			
			while(result.next()) {
				member = null;
				member = new Clan_Member();
				member.setClan_number(result.getInt("clan_number"));
				member.setUser_id(result.getString("user_id"));
				members.add(member);
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
			}
		}
		
		return members;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		Clan_Member member = (Clan_Member)obj;
		PreparedStatement pstmt = null;
		String sql = "insert into clan_member (clan_number , user_id) values (?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getClan_number());
			pstmt.setString(2, member.getUser_id());
			
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
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		Clan_Member member = (Clan_Member)obj;
		PreparedStatement pstmt = null;
		String sql = "delete from clan_member where user_id = ? and clan_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUser_id());
			pstmt.setInt(2, member.getClan_number());
			
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
		Clan_Member member = (Clan_Member)obj;
		boolean return_value = false;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from Clan_Member where user_id = ? and clan_number = ?";
		try {
			/*
			 * private String user_id;
			 * private int clan_number;
			 */
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUser_id());
			pstmt.setInt(2, member.getClan_number());
			result = pstmt.executeQuery();
			
			if(result.next())
				return_value = true;
			
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
			}
		}
		return return_value;
	}


}
