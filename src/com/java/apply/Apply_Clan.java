package com.java.apply;

import java.util.Date;

public class Apply_Clan {

	/*
	1. 지원하기
	2. 지원 결과 확인
	3. status 넣어야겟네
	4. user 가 그냥 guest 혹은 팀을 구하는것
	5. group 이 팀원을 구하는것 . 
	*/
	private int clan_number;
	private int status;
	private String title;
	private String textarea;
	private boolean guest;
	
	private Date create_date;
	private int categori;
	
	public Apply_Clan() {
		
	}


	public int getClan_number() {
		return clan_number;
	}


	public void setClan_number(int clan_number) {
		this.clan_number = clan_number;
	}


	


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTextarea() {
		return textarea;
	}


	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}


	public boolean isGuest() {
		return guest;
	}


	public void setGuest(boolean guest) {
		this.guest = guest;
	}


	public Date getCreate_date() {
		return create_date;
	}


	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}


	public int getCategori() {
		return categori;
	}


	public void setCategori(int categori) {
		this.categori = categori;
	}
	
}
