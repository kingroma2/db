package com.java.clan;

import java.util.Date;

import com.java.util.Status;

public class Clan {
	public int CLAN_NORMAL = Status.CLAN_NORMAL;
	public int CLAN_SPECIAL = Status.CLAN_SPECIAL;
	public int CLAN_ERROR = Status.CLAN_ERROR;
	public int CLAN_DELETE = Status.CLAN_DELETE;
	/*
	 * 
	1. 그룹 가입하기
	2. 그룹 누가있는지 조회
	3. 그룹 탈퇴 
	4. 그룹 intro 변경
	*/
	/*
	 * 1. 메치 장소
	2. 메치 시간
	3. 그룹 대 그룹
	4. 게스트 대 게스트
	5. 그룹 대 게스트 
	6. 인원 제한 
	 * */
	private int clan_number;
	private String chief_id;
	private int status;
	
	private int categori;
	private String title;
	private String textarea;
	private String memo; //관리자 memo
	
	private String position;
	private String time;
	private Date clan_create_date;
	private String phone;
	
	
	
	public Clan() {
		
	}



	public int getCLAN_NORMAL() {
		return CLAN_NORMAL;
	}



	public void setCLAN_NORMAL(int cLAN_NORMAL) {
		CLAN_NORMAL = cLAN_NORMAL;
	}



	public int getCLAN_SPECIAL() {
		return CLAN_SPECIAL;
	}



	public void setCLAN_SPECIAL(int cLAN_SPECIAL) {
		CLAN_SPECIAL = cLAN_SPECIAL;
	}



	public int getCLAN_ERROR() {
		return CLAN_ERROR;
	}



	public void setCLAN_ERROR(int cLAN_ERROR) {
		CLAN_ERROR = cLAN_ERROR;
	}



	public int getCLAN_DELETE() {
		return CLAN_DELETE;
	}



	public void setCLAN_DELETE(int cLAN_DELETE) {
		CLAN_DELETE = cLAN_DELETE;
	}



	public int getClan_number() {
		return clan_number;
	}



	public void setClan_number(int clan_number) {
		this.clan_number = clan_number;
	}



	public String getChief_id() {
		return chief_id;
	}



	public void setChief_id(String chief_id) {
		this.chief_id = chief_id;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getCategori() {
		return categori;
	}



	public void setCategori(int categori) {
		this.categori = categori;
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



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}






	public Date getClan_create_date() {
		return clan_create_date;
	}



	public void setClan_create_date(Date clan_create_date) {
		this.clan_create_date = clan_create_date;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
