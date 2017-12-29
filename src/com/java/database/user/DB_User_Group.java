package com.java.database.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.user.User_Group;

public class DB_User_Group implements DB_All{

	/*
	 * private int group;
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
		String sql = "create table user_group ( group_number int , user_id varchar(20) )";
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
		ArrayList<User_Group> groups = new ArrayList<User_Group>();
		String id = (String)obj;
		
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String sql = "select * from user_group where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			User_Group group = null;

			while(result.next()) {
				group = null;
				group = new User_Group();
				
				group.setGroup_number(result.getInt("group_number"));
				group.setUser_id(result.getString("user_id"));
				groups.add(group);
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
		
		return groups;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		User_Group user_group = (User_Group)obj;
		PreparedStatement pstmt = null;
		String sql = "insert into user_group (user_id , group_number) value (?,?)";
		try {
			String user_id = user_group.getUser_id();
			int group_number = user_group.getGroup_number();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, group_number);
			
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
		User_Group group = (User_Group)obj;
		String user_id = group.getUser_id();
		int group_number = group.getGroup_number();
		String sql = "delete from user_group where user_id = ? and group_number = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setInt(2, group_number);
			
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

}
