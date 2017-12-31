package com.java.database.game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.game.Game;
import com.java.util.MyDate;

public class DB_Game implements DB_All{

	/*
	 *  private int game_number
		private int home;
		private int away;
		private int win;
		private int lose;
		private Date game_date;
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
	
	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		Game game = null;
		int game_number = (int)obj;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String sql = "select * from game where game_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, game_number);
			
			result = pstmt.executeQuery();
			if(result.next()) {
				game = new Game();
				game.setHome(result.getInt("home"));
				game.setAway(result.getInt("away"));
				game.setWin(result.getInt("win"));
				game.setLose(result.getInt("lose"));
				game.setGame_date(new MyDate().changeStringToDate(result.getString("game_date")));
				game.setPosition(result.getString("position"));
				
				
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
		return game;
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

	
	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		Game game = (Game)obj;
		PreparedStatement pstmt = null;
		String sql = "update game set home = ? , away = ? , win = ? , lose = ? position = ? where game_number = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, game.getHome());
			pstmt.setInt(2, game.getAway());
			pstmt.setInt(3, game.getWin());
			pstmt.setInt(4, game.getLose());
			pstmt.setString(5, game.getPosition());
			pstmt.setInt(6, game.getGame_number());
			
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
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}



	
	public Object selectAll(Object obj) {
		int clan_number = (int)obj;
		ArrayList<Game> games = null;
		Game game = null;
		String sql = "select * from game where home = ? or away = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, clan_number);
			pstmt.setInt(2, clan_number);
			
			result = pstmt.executeQuery();
			games = new ArrayList<Game>();
			while(result.next()) {
				game = null;
				game = new Game();
								
				game.setGame_number(result.getInt("game_number"));
				game.setHome(result.getInt("home"));
				game.setAway(result.getInt("away"));
				game.setWin(result.getInt("win"));
				game.setLose(result.getInt("lose"));
				game.setGame_date(new MyDate().changeStringToDate(result.getString("game_date")));
				game.setPosition(result.getString("position"));
				
				games.add(game);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games ;
	}

	@Override
	public boolean isObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
