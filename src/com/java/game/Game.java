package com.java.game;

import java.util.Date;

public class Game {
	/*
	
	1. ��ġ ���
	2. ��ġ �ð�
	3. �׷� �� �׷�
	4. �Խ�Ʈ �� �Խ�Ʈ
	5. �׷� �� �Խ�Ʈ 
	6. �ο� ����  
	
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