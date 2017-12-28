package com.java.util;

import java.util.ArrayList;

/*
 * 1. 축구
 * 2. 농구
 * 3. 야구
 * 4. 베드민턴
 * 
 */
public class Categori {
	/*
	1. 종목
	2. 종목 추가 
	3. 
	*/
	
	public int SOCCER = 1;
	public int BASKETBALL = 2;
	
	ArrayList<Integer> categories;
	
	public Categori() {
		init();
	}
	
	public void init() {
		categories = new ArrayList<Integer>();
		
	}
	
	public void list() {
		
		
	}
}
