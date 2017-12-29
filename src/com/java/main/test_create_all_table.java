package com.java.main;

import com.java.database.DB_All;
import com.java.database.user.DB_User;
import com.java.database.user.DB_User_Friend;
import com.java.database.user.DB_User_Group;

public class test_create_all_table {
	public test_create_all_table() {
		user_init();
		
	}
	
	public void user_init() {
		this.dbCrateUserFriend();
		this.dbCreateUserGroup();
		this.dbCreateUser();
	}
	
	public void dbCrateUserFriend() {
		DB_All db = new DB_User_Friend();
		db.start();
		db.create_table();
		db.end();
	}
	
	public void dbCreateUserGroup() {
		DB_All db = new DB_User_Group();
		db.start();
		db.create_table();
		db.end();
	}
	
	public void dbCreateUser() {
		DB_All db = new DB_User();
		db.start();
		db.create_table();
		db.end();
	}
}
