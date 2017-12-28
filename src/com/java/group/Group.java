package com.java.group;

import java.util.ArrayList;
import java.util.Date;

public class Group {
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
	private int group_number;
	private int chief_number;
	private int status;
	
	private int categori;
	private String title;
	private String textarea;
	private String memo; // 
	
	private String where;
	private String time;
	private Date account_date;
	private Date group_create_date;
	private String phone;
	
	private ArrayList<Integer> member_number;
	
	public Group() {
		
	}
}
