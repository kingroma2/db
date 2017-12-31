package com.java.controller;

import java.util.ArrayList;

import com.java.database.DB_All;
import com.java.database.user.DB_User;
import com.java.database.user.DB_User_Clan;
import com.java.database.user.DB_User_Friend;
import com.java.user.User;
import com.java.user.User_Clan;
import com.java.user.User_Friend;

public class Controller_User implements Controller{
	
	DB_All db = null;
	public Controller_User() {
	}
	
	public boolean isUser(String user_id) {
		boolean return_value = true;
		db = new DB_User();
		db.start();
		User user_temp = (User)db.select(user_id);
		db.end();
		if(user_temp != null) {
			
		}else {
			return_value = false;
		}
		
		return return_value;
	}
	
	/** user **/
	public User getUser(String user_id) {
		User user = null;
		db = new DB_User();
		db.start();
		user = (User)db.select(user_id);
		db.end();
		db = null;
		return user;
	}
	public boolean insertUser(User user) {
		boolean return_value = true;
		
		//User user_temp = (User)db.select(user.getId());
		if(!isUser(user.getId())) {
			db = new DB_User();
			db.start();
			db.insert(user);
			db.end();
			db = null;
		}
		else 
			return_value = false;
		
		return return_value;
	}
	public void updateUser(User user) {
		//User user_temp = (User)db.select(user.getId());
		if(isUser(user.getId())) {
			db = new DB_User();
			db.start();
			db.update(user);
			db.end();
			db = null;
		}
	}
	public void deleteUser(String user_id) {
		//User user_temp = (User)db.select(user_id);
		if(isUser(user_id)) {
			User user = new User();
			user.setId(user_id);
			db = new DB_User();
			db.start();
			db.delete(user);
			db.end();
			db = null;
		}
	}
	/** user **/
	
	
	/** user_friend **/
	public void isFriend() {
		
	}
	public ArrayList<User_Friend> getUserFriend(String user_id) {
		
		if(this.isUser(user_id)) {
			db = new DB_User_Friend();
			db.start();
			ArrayList<User_Friend> friends = (ArrayList<User_Friend>)db.select(user_id);
			db.end();
			return friends;
		}else
			return null;
	}
	public boolean insertUserFriend(User_Friend friend) {
		if(this.isUser(friend.getUser_id())) {
			db = new DB_User_Friend();
			db.start();
			if(!db.isObject(friend))
				db.insert(friend);
			db.end();
			return true;
		}else {
			return false;
		}
	}
	public boolean deleteUserFriend(User_Friend friend) {
		if(this.isUser(friend.getUser_id())) {
			db = new DB_User_Friend();
			db.start();
			if(db.isObject(friend))
				db.delete(friend);
			db.end();
			return true;
		}
		
		return false;
	}
	/** user_friend **/
	
	/** user_clan **/
	public ArrayList<User_Clan> getUserClan(String user_id) {
		ArrayList<User_Clan> clans = null;
		if(this.isUser(user_id)) {
			db = new DB_User_Clan();
			db.start();
			
			clans = (ArrayList<User_Clan>)db.select(user_id);
			
			db.end();
		}
		return clans;
	}
	public boolean insertUserClan(User_Clan clan) {
		if(this.isUser(clan.getUser_id())) {
			db = new DB_User_Clan();
			db.start();
			if(!db.isObject(clan))
				db.insert(clan);
			
			db.end();
			return true;
		}
		return false;
	}
	public boolean deleteUserClan(User_Clan clan) {
		boolean return_value = false;
		if(this.isUser(clan.getUser_id())) {
			db = new DB_User_Clan();
			db.start();
			if(db.isObject(clan))
				db.delete(clan);
			db.end();
			return_value = true;
		}
		return return_value;
	}
	/** user_clan **/
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMe() {
		// TODO Auto-generated method stub
		print(" *******************************************************");
		print(" user controller ");
		print(" 1. get user");
		print(" 2. insert user");
		print(" 3. update user");
		print(" 4. delete user etc..");
		print(" *******************************************************");
	}
	
	public void print(String str) {
		System.out.println(str);
	}
}
