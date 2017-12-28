package com.java.main;

import java.util.Date;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.database.user.DB_User;
import com.java.user.User;
import com.java.util.MyDate;

public class test {
	public test() {
		dbUpdateUser();
	}
	
	public void dbUpdateUser() {
		User user = dbSelectUser("kingroma");
		DB_All db = new DB_User();
		user.setPw("12345");
		db.start();
		db.update(user);
		db.end();
	}
	
	public void dbInsertUser() {
		DB_All db = new DB_User();
		User user = new User();
		user.setId("kingroma");
		user.setPw("1234");
		user.setIntro("hello");
		user.setPhone("01040764555");
		user.setPosition("¿Œ√µ");
		user.setBirth(new Date());
		
		db.start();
		db.insert(user);
		db.end();
	}
	
	public User dbSelectUser(String id) {
		DB_All db = new DB_User();
		db.start();
		User user = (User)db.select(id);
		db.end();
		return user;
		//System.out.println(user.getIntro());
	}
	public void dbPing() {
		DB db = new DB();
		db.start();
		db.end();
	}
	
	public void dbCreateUserTable() {
		DB_All db = new DB_User();
		db.start();
		db.create_table();
		db.end();
	}
	
	public void timeTest() {
		System.out.println("time test start");
		//System.out.println(new Date());
		
		System.out.println(new MyDate().getCurrentDateByFormat());
		
		System.out.println("time test end");
	}
}
