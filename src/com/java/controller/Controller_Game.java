package com.java.controller;

import java.util.ArrayList;

import com.java.database.DB_All;
import com.java.database.game.DB_Game;
import com.java.game.Game;

public class Controller_Game implements Controller{
	
	DB_All db = null;
	public Game getGame(int game_number) {
		Game game = null;
		db = new DB_Game();
		db.start();
		game = (Game)db.select(game_number);
		db.end();
		
		return game;
	}
	
	public void insertGame(Game game) {
		db = new DB_Game();
		db.start();
		
		db.insert(game);
		
		db.end();
	}
	public void updateGame(Game game) {
		db = new DB_Game();
		db.start();
		db.update(game);
		db.end();
	}
	public ArrayList<Game> getGames(int clan_number) {
		DB_Game db_game = new DB_Game();
		db_game.start();
		ArrayList<Game> games = (ArrayList<Game>)db_game.selectAll(clan_number);
		db_game.end();
		
		return games;
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMe() {
		// TODO Auto-generated method stub
		
	}
	
}
