package com.java.apply;

import java.util.Date;

public class Apply_Clan {

	/*
	1. �����ϱ�
	2. ���� ��� Ȯ��
	3. status �־�߰ٳ�
	4. user �� �׳� guest Ȥ�� ���� ���ϴ°�
	5. group �� ������ ���ϴ°� . 
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
