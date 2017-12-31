package com.java.database.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.user.User;
import com.java.util.MyDate;
import com.java.util.Status;
//import com.mysql.jdbc.PreparedStatement;

public class DB_User implements DB_All{
	public int USER_NORMAL = Status.USER_NORMAL;
	public int USER_SPECIAL = Status.USER_SPECIAL;
	public int USER_ERROR = Status.USER_ERROR;
	public int USER_DELETE = Status.USER_DELETE;
	/*
	private String id;
	private String pw;
	private String intro;
	private String iconUrl;
	private int status;
	private String memo;
	
	
	private Date account_date;
	private Date birth;
	private String phone;
	private String where;
	*/
	
	DB db = null;
	Connection conn = null;
	MyDate myDate = null;
	
	public DB_User() {
		myDate = new MyDate();
	}
	
	
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
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		boolean return_value = false;
		String user_id = (String)obj;
		String sql = "select id from user where id = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				if(result.getString("id").equals(user_id))
					return_value = true;
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
		return return_value;
	}

	@Override
	public boolean create_table() {
		// TODO Auto-generated method stub
		Statement stmt = null;
		
		String sql = "create table user ("
				+ "id varchar(20) primary key,"
				+ "pw varchar(20) not null,"
				+ "intro varchar(500) default ' ',"
				+ "iconUrl varchar(500) default ' ',"
				+ "status int default "+USER_NORMAL+" ,"
				+ "memo varchar(500) default ' ',"
				+ "account_date varchar(20) default ' ',"
				+ "birth varchar(20) default ' ',"
				+ "phone varchar(20) default ' ',"
				+ "position varchar(100) default ' '"
				+ ");";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt!=null)
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		String id = (String)obj;
		String sql = "select * from user where id=?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		User user = null;
		try {
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				user = this.setUserByResult(result);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(result!=null) {
					result.close();
					result = null;
				}
				if(pstmt!=null) {
					pstmt.close();
					pstmt = null;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		User user = (User)obj;
		String sql = "insert into user(id,pw,intro,iconUrl,status,"
				+ "memo,account_date,birth,phone,position ) "
				+ "values(?,?,?,?,?,"
				+ "?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getIntro());
			pstmt.setString(4, user.getIconUrl());
			pstmt.setInt(5, this.USER_NORMAL);
			pstmt.setString(6,"");
			pstmt.setString(7, myDate.getCurrentDateByFormat());
			pstmt.setString(8,myDate.changeDateToString(user.getBirth()));
			pstmt.setString(9,user.getPhone());
			pstmt.setString(10, user.getPosition());
			
			
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
		
		return true;
	}
	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		User user = (User)obj;
		
		String sql = "update user "
				+ "set pw = ? , intro = ? , iconUrl = ? , status = ? ,"
				+ "memo = ? , account_date = ? , birth = ? , phone = ? , position = ? "
				+ "where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getIntro());
			pstmt.setString(3, user.getIconUrl());
			pstmt.setInt(4, user.getStatus());
			pstmt.setString(5, user.getMemo());
			pstmt.setString(6, myDate.changeDateToString(user.getAccount_date()));
			pstmt.setString(7, myDate.changeDateToString(user.getBirth()));
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getPosition());
			pstmt.setString(10,user.getId());
			
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
		
		return true;
	}
	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		User user = (User)obj;
		String id = user.getId();
		String sql = "update user "
				+ "set status = ? "
				+ "where id = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			
			pstmt.setInt(1, this.USER_DELETE);
			pstmt.setString(2, id);
			
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
		
		return true;
	}

	
	public User setUserByResult(ResultSet result) {
		User user = new User();
		
		try {
			user.setId(result.getString("id"));
			user.setPw(result.getString("pw"));
			user.setIntro(result.getString("intro"));
			user.setIconUrl(result.getString("iconUrl"));
			user.setStatus(result.getInt("status"));
			
			user.setMemo(result.getString("memo"));
			user.setAccount_date(myDate.changeStringToDate(result.getString("account_date")));
			user.setBirth(myDate.changeStringToDate(result.getString("birth")));
			user.setPhone(result.getString("phone"));
			user.setPosition(result.getString("position"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}


	
	


}
