package com.java.game;

import java.util.Date;

public class Game {
	/*
	
	1. 메치 장소
	2. 메치 시간
	3. 그룹 대 그룹
	4. 게스트 대 게스트
	5. 그룹 대 게스트 
	6. 인원 제한  
	
	*/
	
	private int game_number;
	private int home;
	private int away;
	private int win;
	private int lose;
	private Date game_date;
	private String position;
	
	
	public Game() {
		
	}


	public int getHome() {
		return home;
	}


	public void setHome(int home) {
		this.home = home;
	}


	public int getAway() {
		return away;
	}


	public void setAway(int away) {
		this.away = away;
	}


	public int getWin() {
		return win;
	}


	public void setWin(int win) {
		this.win = win;
	}


	public int getLose() {
		return lose;
	}


	public void setLose(int lose) {
		this.lose = lose;
	}


	public Date getGame_date() {
		return game_date;
	}


	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public int getGame_number() {
		return game_number;
	}


	public void setGame_number(int game_number) {
		this.game_number = game_number;
	}
	
}