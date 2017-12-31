package com.java.controller;

import com.java.clan.Clan;
import com.java.database.DB_All;
import com.java.database.clan.DB_Clan;

public class Controller_Clan implements Controller{
	
	DB_All db = null;
	public Clan getClan(int clan_number) {
		db = new DB_Clan();
		db.start();
		Clan clan = (Clan)db.select(clan_number);
		db.end();
		
		return clan;
	}
	public void insertClan(Clan clan) {
		db = new DB_Clan();
		db.start();
		
		db.insert(clan);
		
		db.end();
	}
	public void updateClan(Clan clan) {
		db = new DB_Clan();
		db.start();
		
		db.update(clan);
		
		db.end();
	}
	public void deleteClan(Clan clan) {
		db = new DB_Clan();
		db.start();
		db.delete(clan);
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
