package com.java.apply;

public class Apply_User {
	
	private String user_id;
	private int status; 
	private String title;
	private String textarea;
	private boolean guest; 
	
	private int categori;
	
	
	public Apply_User() {
		
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
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


	public int getCategori() {
		return categori;
	}


	public void setCategori(int categori) {
		this.categori = categori;
	}
	
	
	
}
