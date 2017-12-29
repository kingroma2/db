package com.java.main;

import com.java.database.DB_All;
import com.java.database.clan.DB_Clan;
import com.java.database.user.DB_User;
import com.java.database.user.DB_User_Clan;
import com.java.database.user.DB_User_Friend;

public class Create_All_Tables {
	public Create_All_Tables() {
		user_init();
		clan_init();
		
	}
	
	public void user_init() {
		this.dbCrateUserFriend();
		this.dbCreateUserClan();
		this.dbCreateUser();
		
	}
	
	public void clan_init() {
		this.dbCreateClan();
		
	}
	
	public void dbCreateClan() {
		DB_All db = new DB_Clan();
		db.start();
		db.create_table();
		db.end();
	}
	
	public void dbCrateUserFriend() {
		DB_All db = new DB_User_Friend();
		db.start();
		db.create_table();
		db.end();
	}
	
	public void dbCreateUserClan() {
		DB_All db = new DB_User_Clan();
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
