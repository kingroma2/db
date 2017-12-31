package com.java.controller;

import java.util.ArrayList;

import com.java.apply.Apply_Clan;
import com.java.apply.Apply_User;
import com.java.database.DB_All;
import com.java.database.apply.DB_Apply_Clan;
import com.java.database.apply.DB_Apply_User;

public class Controller_Apply implements Controller{
	
	DB_All db = null;
	public ArrayList<Apply_User> getApplyUser(String user_id) {
		db = new DB_Apply_User();
		db.start();
		
		ArrayList<Apply_User> applies = (ArrayList<Apply_User>)db.select(user_id);
		
		db.end();
		
		return applies ;
	}
	public void insertApplyUser(Apply_User apply) {
		db = new DB_Apply_User();
		db.start();
		
		db.insert(apply);
		
		db.end();
		
	}
	public void deleteApplyUser(Apply_User apply){
		db = new DB_Apply_User();
		db.start();
		
		db.delete(apply);
		
		db.end();
	}
	
	public Apply_Clan getApplyClan(int clan_number) {
		Apply_Clan apply = null;
		db = new DB_Apply_Clan();
		db.start();
		apply = (Apply_Clan)db.select(clan_number);
		db.end();
		
		return apply;
	}
	public void insertApplyClan(Apply_Clan clan) {
		db = new DB_Apply_Clan();
		db.start();
		db.insert(clan);
		db.end();
	}
	public void deleteApplyClan(int clan_number ) {
		db = new DB_Apply_Clan();
		db.start();
		db.delete(clan_number);
		db.end();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMe() {
		// TODO Auto-generated method stub
		
	}

}
