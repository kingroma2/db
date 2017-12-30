package com.java.database.game;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.game.Game;
import com.java.util.MyDate;

public class DB_Game implements DB_All{
	/*
	  	private int home;
		private int away;
		private int win;
		private int lose;
		private Date date;
		private String position;
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
	
	
	
	//+ "clan_number int AUTO_INCREMENT primary key,"
	@Override
	public boolean create_table() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "create table game ("
				+ "game_number int AUTO_INCREMENT primary key,"
				+ "home int , away int , win int , lose int , game_date varchar(20), position varchar(200))";
		
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


	/*
	 *  private int game_number
		private int home;
		private int away;
		private int win;
		private int lose;
		private Date game_date;
		private String position;
	 */
	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		Game game = (Game)obj;
		PreparedStatement pstmt = null;
		String sql = "insert into game (home , away , win , lose , game_date , position) "
				+ "values (?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, game.getHome());
			pstmt.setInt(2, game.getAway());
			pstmt.setInt(3, game.getWin());
			pstmt.setInt(4, game.getLose());
			pstmt.setString(5, new MyDate().changeDateToString(game.getGame_date()));
			pstmt.setString(6, game.getPosition());
			
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
	 *  private int game_number
		private int home;
		private int away;
		private int win;
		private int lose;
		private Date game_date;
		private String position;
	 */
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
