
package com.java.user;

import java.util.ArrayList;
import java.util.Date;

import com.java.util.Status;

public class User {
	public int USER_NORMAL = Status.USER_NORMAL;
	public int USER_SPECIAL = Status.USER_SPECIAL;
	public int USER_ERROR = Status.USER_ERROR;
	public int USER_DELETE = Status.USER_DELETE;
	/*
	-- use case
	1. 로그인 
	2. 회원가입 
	3. 아이디 찾기
	4. 비밀번호 찾기
	5. 나의 정보 수정 
	*/
	//private int user_number; 
	private String id = null;
	private String pw = null;
	private String intro = null;
	private String iconUrl = null;
	private int status = 1;
	//private ArrayList<Integer> groups = null;  // 내가 무슨 그룹에 들어있는지 . 
	private String memo = null;
	
	
	private Date account_date = null;
	private Date birth = null;
	private String phone = null;
	private String position = null;
	
	
	public User() {
		id = "";
		pw = "";
		intro = "";
		iconUrl = "";
		status = 1;
		memo = "";
		
		
		account_date = null;
		birth = null;
		phone = "";
		position = "";
	}
	
	public void init() {
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getAccount_date() {
		return account_date;
	}

	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
}
