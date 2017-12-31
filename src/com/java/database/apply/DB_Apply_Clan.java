package com.java.database.apply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.apply.Apply_Clan;
import com.java.database.DB;
import com.java.database.DB_All;
import com.java.util.MyDate;
import com.java.util.Status;

public class DB_Apply_Clan implements DB_All{
	/*
	 * private int clan_number;
	 * private int status;
	 * private String title;
	 * private String textarea;
	 * private boolean guest;
	 * privaet Date create_date;
	 */
	public int APPLY_NORMAL = Status.APPLY_NORMAL;; 
	public int APPLY_ERROR = Status.APPLY_ERROR;
	
	DB db = new DB();
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
		String sql = "create table apply_clan ("
				+ "clan_number int ,"
				+ "status int , "
				+ "title varchar(200),"
				+ "textarea varchar(500),"
				+ "guest boolean,"
				+ "create_date varchar(20),"
				+ "categori int"
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
		//ArrayList<Apply_Clan> applies = null;
		Apply_Clan apply = null;
		int clan_number = (int)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from apply_clan where clan_number = ? order by create_date desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, clan_number);
			
			result = pstmt.executeQuery();
			//applies = new ArrayList<Apply_Clan>();
			if(result.next()) {
				apply = null;
				apply = new Apply_Clan();
				
				apply.setClan_number(result.getInt("clan_number"));
				apply.setStatus(result.getInt("status"));
				apply.setTitle(result.getString("title"));
				apply.setTextarea(result.getString("textarea"));
				apply.setGuest(result.getBoolean("guest"));
				apply.setCreate_date(new MyDate().changeStringToDate(result.getString("create_date")));
				apply.setCategori(result.getInt("categori"));
				//applies.add(apply);
				
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
		return apply;
	}

	@Override
	public boolean insert(Object obj) {
		Apply_Clan apply = (Apply_Clan)obj;
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt = null;
		String sql = "insert into apply_clan (clan_number , status , title , textarea , guest , create_date,categori) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, apply.getClan_number());
			pstmt.setInt(2, this.APPLY_NORMAL);
			pstmt.setString(3, apply.getTitle());
			pstmt.setString(4, apply.getTextarea());
			pstmt.setBoolean(5, apply.isGuest());
			pstmt.setString(6, new MyDate().getCurrentDateByFormat());
			pstmt.setInt(7, apply.getCategori());
			
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
		Apply_Clan apply = (Apply_Clan)obj;
		PreparedStatement pstmt = null;
		String sql = "update apply_clan set status = ? , title = ? , textarea = ? , guest = ? where clan_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, apply.getStatus());
			pstmt.setString(2, apply.getTitle());
			pstmt.setString(3, apply.getTextarea());
			pstmt.setBoolean(4, apply.isGuest());
			pstmt.setInt(5, apply.getClan_number());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		int clan_number = (int)obj;
		PreparedStatement pstmt = null;
		String sql = "delete from apply_clan where clan_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, clan_number);
			
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
	 * private int clan_number;
	 * private int status;
	 * private String title;
	 * private String textarea;
	 * private boolean guest;
	 * privaet Date create_date;
	 */
	@Override
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		boolean return_value = false;
		Apply_Clan apply = (Apply_Clan)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select * from apply_clan where clan_number = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, apply.getClan_number());
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
