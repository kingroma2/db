package com.java.group;

import java.util.ArrayList;
import java.util.Date;

public class Group {
	/*
	 * 
	1. �׷� �����ϱ�
	2. �׷� �����ִ��� ��ȸ
	3. �׷� Ż�� 
	4. �׷� intro ����
	*/
	/*
	 * 1. ��ġ ���
	2. ��ġ �ð�
	3. �׷� �� �׷�
	4. �Խ�Ʈ �� �Խ�Ʈ
	5. �׷� �� �Խ�Ʈ 
	6. �ο� ���� 
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
