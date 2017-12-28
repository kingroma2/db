package com.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	
	//³ªÀÇ Æ÷¸ä
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	
	public MyDate() {
	}
	
	public Date getCurrentDate() {
		return new Date();
	}
	
	public String getCurrentDateByFormat() {
		return dateformat.format(new Date());
	}
	
	public Date changeStringToDate(String str) {
		try {
			return (Date)dateformat.parse(str);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String changeDateToString(Date date) {
		return dateformat.format(date);
	}
	
	
}
