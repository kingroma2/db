package com.java.main;

import com.java.database.DB_All;
import com.java.database.apply.DB_Apply_Clan;
import com.java.database.apply.DB_Apply_User;
import com.java.database.clan.DB_Clan;
import com.java.database.clan.DB_Clan_Member;
import com.java.database.game.DB_Game;
import com.java.database.user.DB_User;
import com.java.database.user.DB_User_Clan;
import com.java.database.user.DB_User_Friend;

public class Create_All_Tables {
	public Create_All_Tables() {
		this.user_init();
		this.clan_init();
		this.apply_init();
		this.game_init();
	}
	
	
	public void user_init() {
		this.dbCrateUserFriend();
		this.dbCreateUserClan();
		this.dbCreateUser();
		
	}
	
	public void clan_init() {
		this.dbCreateClan();
		this.dbCreateClanMember();
	}
	
	public void apply_init() {
		this.dbCreateApplyClan();
		this.dbCreateApplyUser();
	}
	
	public void game_init() {
		this.dbCreateGame();
	}
	
	public void dbCreateGame() {
		DB_All db = new DB_Game();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbCreateApplyUser() {
		DB_All db = new DB_Apply_User();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbCreateApplyClan() {
		DB_All db = new DB_Apply_Clan();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbCreateClanMember() {
		DB_All db = new DB_Clan_Member();
		db.start();
		
		db.create_table();
		
		db.end();
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
