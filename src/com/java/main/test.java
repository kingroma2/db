package com.java.main;

import java.util.ArrayList;
import java.util.Date;

import com.java.database.DB;
import com.java.database.DB_All;
import com.java.database.clan.DB_Clan;
import com.java.database.user.DB_User;
import com.java.database.user.DB_User_Clan;
import com.java.database.user.DB_User_Friend;
import com.java.user.User;
import com.java.user.User_Clan;
import com.java.user.User_Friend;
import com.java.util.MyDate;

public class test {
	public test() {
		//Create_All_Tables t = new Create_All_Tables();
		
		
	}
	
	public void dbCreateClan() {
		DB_All db = new DB_Clan();
		db.start();
		db.create_table();
		db.end();
	}
	public void dbDeleteUserFriend() {
		DB_All db =  new DB_User_Friend();
		User_Friend friend = new User_Friend();
		friend.setUser_id("kingroma");
		friend.setFriend_id("kingroma2");
		db.start();
		
		db.delete(friend);
		
		db.end();
	}
	public void dbSelectUserFriend() {
		DB_All db =  new DB_User_Friend();
		db.start();
		
		
		ArrayList<User_Friend> friends = (ArrayList<User_Friend>)db.select("kingroma");
		
		
		db.end();
		
		for(int i = 0 ; i < friends.size() ; i ++) {
			print(friends.get(i).getUser_id()+" / "+friends.get(i).getFriend_id());
		}
	}
	
	public void dbInsertUserFriend() {
		User_Friend friend = new User_Friend();
		friend.setFriend_id("kingroma2");
		friend.setUser_id("kingroma");
		DB_All db =  new DB_User_Friend();
		db.start();
		
		
		db.insert(friend);
		
		db.end();
	}
	
	public void dbCrateUserFriend() {
		DB_All db = new DB_User_Friend();
		db.start();
		db.create_table();
		db.end();
	}
	
	public void dbDeleteUserClan() {
		DB_All db = new DB_User_Clan();
		db.start();
		User_Clan clan = new User_Clan();
		clan.setUser_id("kingroma");
		clan.setClan_number(1);
		
		db.delete(clan);
		
		db.end();
	}
	
	public void dbInsertUserClan() {
		DB_All db = new DB_User_Clan();
		db.start();
		User_Clan clan = new User_Clan();
		clan.setUser_id("kingroma");
		clan.setClan_number(1);
		
		db.insert(clan);
		
		db.end();
	}
	
	public void dbSelectUserClan() {
		DB_All db = new DB_User_Clan();
		db.start();
		ArrayList<User_Clan> clans = (ArrayList<User_Clan>)db.select("kingroma");
		
		for(int i = 0 ; i < clans.size() ; i ++) {
			print(clans.get(i).getClan_number()+" / "+clans.get(i).getUser_id());
		}
		
		
		db.end();
	}
	
	public void dbCreateUserClan() {
		DB_All db = new DB_User_Clan();
		db.start();
		db.create_table();
		db.end();
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
		user.setPosition("ÀÎÃµ");
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
	
	
	public void print(String str) {
		System.out.println(str);
	}
}
