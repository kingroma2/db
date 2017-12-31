package com.java.main;

import java.util.ArrayList;
import java.util.Date;

import com.java.apply.Apply_Clan;
import com.java.apply.Apply_User;
import com.java.clan.Clan;
import com.java.clan.Clan_Member;
import com.java.controller.Controller_Apply;
import com.java.controller.Controller_User;
import com.java.database.DB;
import com.java.database.DB_All;
import com.java.database.apply.DB_Apply_Clan;
import com.java.database.apply.DB_Apply_User;
import com.java.database.clan.DB_Clan;
import com.java.database.clan.DB_Clan_Member;
import com.java.database.game.DB_Game;
import com.java.database.user.DB_User;
import com.java.database.user.DB_User_Clan;
import com.java.database.user.DB_User_Friend;
import com.java.user.User;
import com.java.user.User_Clan;
import com.java.user.User_Friend;
import com.java.util.MyDate;

public class test {
	public test() {
		controller_apply();
	}
	public void controller_apply() {
		Controller_Apply controller = new Controller_Apply();
		controller.getApplyUser("kingroma");
	}
	public void controller_user() {
	
	}
	public void controller_user_insert() {
		Controller_User controller = new Controller_User();
		User user = new User();
		user.setId("king");
		user.setPw("4235");
		user.setBirth(new MyDate().getCurrentDate());
		controller.insertUser(user);
		System.out.println(user);
	}
	
	public void dbCreateGame() {
		DB_All db = new DB_Game();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbSelectApplyUser() {
		DB_All db = new DB_Apply_User();
		db.start();
		
		ArrayList<Apply_User> applies = (ArrayList<Apply_User>)db.select("kingroma");
		
		for(int i = 0 ; i < applies.size() ; i ++) {
			print(applies.get(i).getUser_id()+" / "+applies.get(i).getTitle());
		}
		
		db.end();
	}
	
	public void dbInsertApplyUser() {
		Apply_User apply = new Apply_User();
		apply.setCategori(1);
		apply.setGuest(true);
		apply.setStatus(1);
		apply.setTextarea("test");
		apply.setTitle("title");
		apply.setUser_id("kingroma");
		
		DB_All db = new DB_Apply_User();
		db.start();
		
		db.insert(apply);
		
		db.end();
	}
	
	public void dbCreateApplyUser() {
		//Apply_User apply = null;
		DB_All db = new DB_Apply_User();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbSelectApplyClan() {
		Apply_Clan apply = null;
		DB_All db = new DB_Apply_Clan();
		db.start();
		apply = (Apply_Clan)db.select(1);
		db.end();
		
		
		print(apply.getClan_number() + " / "+apply.getTitle());
		
	}
	public void dbInsertApplyClan() {
		Apply_Clan apply = new Apply_Clan();
		apply.setClan_number(1);
		apply.setTitle("hello");
		apply.setTextarea("textarea");
		apply.setGuest(true);
		
		DB_All db = new DB_Apply_Clan();
		db.start();
		
		db.insert(apply);
		
		db.end();
	}
	
	public void dbCreateApplyClan() {
		DB_All db = new DB_Apply_Clan();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbDeleteClanMember() {
		Clan_Member member = new Clan_Member();
		member.setClan_number(1);
		member.setUser_id("kingroma");
		
		DB_All db = new DB_Clan_Member();
		db.start();
		
		db.delete(member);
		
		db.end();
		
	}
	
	public void dbSelectClanMember() {
		DB_All db = new DB_Clan_Member();
		db.start();
		
		ArrayList<Clan_Member> members = (ArrayList<Clan_Member>)db.select(1);
		
		db.end();
		
		for(int i = 0 ; i < members.size() ; i ++) {
			print (members.get(i).getClan_number()+" / "+members.get(i).getUser_id());
		}
	}
	
	public void dbInsertClanMember() {
		Clan_Member member = new Clan_Member();
		member.setClan_number(1);
		member.setUser_id("kingroma");
		DB_All db = new DB_Clan_Member();
		db.start();
		
		db.insert(member);
		
		db.end();
	}
	
	public void dbCreateClanMember() {
		DB_All db = new DB_Clan_Member();
		db.start();
		
		db.create_table();
		
		db.end();
	}
	
	public void dbDeleteClan() {
		DB_All db = new DB_Clan();
		db.start();
		Clan clan = (Clan)db.select(2);
		db.delete(clan);
		db.end();
	}
	
	public void dbUpdateClan() {
		DB_All db = new DB_Clan();
		db.start();
		
		Clan clan = (Clan)db.select(2);
		clan.setChief_id("change");
		
		db.update(clan);		
		db.end();
		
		print(clan.getClan_number()+" / "+clan.getChief_id());
	}
	
	public void dbSelectClan() {
		DB_All db = new DB_Clan();
		db.start();
		
		Clan clan = (Clan)db.select(2);
		
		db.end();
		
		print(clan.getClan_number()+" / "+clan.getChief_id());
	}
	
	public void dbInsertClan() {
		Clan clan = new Clan();
		clan.setCategori(1);
		clan.setChief_id("kingroma");
		DB_All db = new DB_Clan();
		db.start();
		db.insert(clan);
		db.end();
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
