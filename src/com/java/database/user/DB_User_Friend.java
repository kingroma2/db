package com.java.database.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.user.User_Friend;

public class DB_User_Friend implements DB_All{

	/*
	 * private String user_id;
	 * private String friend_id;
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
		String sql = "create table user_friend (user_id varchar(20), friend_id varchar(20))";
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
		ArrayList<User_Friend> friends = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from user_friend where user_id = ?";
		String user_id = (String)obj;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			result = pstmt.executeQuery();
			User_Friend friend = null;
			friends = new ArrayList<User_Friend>();
			while(result.next()) {
				friend = null;
				friend = new User_Friend();
				
				friend.setFriend_id(result.getString("friend_id"));
				friend.setUser_id(result.getString("user_id"));
				
				friends.add(friend);
				
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
		
		return friends;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "insert into user_friend ( user_id , friend_id )values(?,?)";
		User_Friend friend = (User_Friend)obj;
		String user_id = friend.getUser_id();
		String friend_id = friend.getFriend_id();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, friend_id);
			
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
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		User_Friend friend = (User_Friend)obj;
		PreparedStatement pstmt = null;
		String sql = "delete from user_friend where user_id = ? and friend_id = ?";
		String user_id = friend.getUser_id();
		String friend_id = friend.getFriend_id();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, friend_id);
			
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
	/*
	* private String user_id;
	 * private String friend_id;
	 * */
	@Override
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		boolean return_value = false;
		User_Friend friend = (User_Friend)obj;
		PreparedStatement pstmt = null;
		String sql = "select * from user_friend where user_id = ? and friend_id = ?";
		ResultSet result  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, friend.getUser_id());
			pstmt.setString(2, friend.getFriend_id());
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
