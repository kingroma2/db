package com.java.database.apply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.apply.Apply_Clan;
import com.java.apply.Apply_User;
import com.java.database.DB;
import com.java.database.DB_All;

public class DB_Apply_User implements DB_All{
	/*
	 * private String user_id;
		private int status; 
		private String title;
		private String textarea;
		private boolean guest; 
		private int categori;
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
		String sql = "create table apply_user ("
				+ "user_id varchar(20),status int , title varchar(200),"
				+ "textarea varchar(500),guest boolean,categori int)";
		
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
		ArrayList<Apply_User> applies = null;
		String user_id = (String)obj;
		Apply_User apply = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select distinct * from apply_user where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			result = pstmt.executeQuery();
			
			applies = new ArrayList<Apply_User>();
			
			while(result.next()) {
				apply = null;
				apply = new Apply_User();
				
				apply.setUser_id(user_id);
				apply.setStatus(result.getInt("status"));
				apply.setTitle(result.getString("title"));
				apply.setTextarea(result.getString("textarea"));
				apply.setGuest(result.getBoolean("guest"));
				apply.setCategori(result.getInt("categori"));
				
				applies.add(apply);
			}
			
			
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
		return applies;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		Apply_User apply = (Apply_User)obj;
		PreparedStatement pstmt = null;
		
		String sql = "insert into apply_user (user_id,status,title,textarea,guest,categori) "
									+ "values (?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, apply.getUser_id());
			pstmt.setInt(2, apply.getStatus());
			pstmt.setString(3, apply.getTitle());
			pstmt.setString(4, apply.getTextarea());
			pstmt.setBoolean(5, apply.isGuest());
			pstmt.setInt(6, apply.getCategori());
			
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
		Apply_User apply = (Apply_User)obj;
		PreparedStatement pstmt = null;
		String sql = "update apply_user set status = ? , title = ? , textarea = ? , guest = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, apply.getStatus());
			pstmt.setString(2, apply.getTitle());
			pstmt.setString(3, apply.getTextarea());
			pstmt.setBoolean(4, apply.isGuest());
			
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
		Apply_User apply = (Apply_User)obj;
		PreparedStatement pstmt = null;
		String sql = "delete from apply_user where user_id = ? and categori = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, apply.getUser_id());
			pstmt.setInt(2, apply.getCategori());
			
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
	 * private String user_id;
		private int status; 
		private String title;
		private String textarea;
		private boolean guest; 
		private int categori;
	 */
	
	@Override
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		boolean return_value = false;
		Apply_User apply = (Apply_User)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from apply_user where user_id = ? and categori = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, apply.getUser_id());
			pstmt.setInt(2, apply.getCategori());
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
