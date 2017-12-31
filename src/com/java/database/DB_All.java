package com.java.database;

public interface DB_All {
	
	public void start();
	public void end();
	
	public boolean create_table();
	
	public Object select(Object obj);
	public boolean insert(Object obj);
	public boolean update(Object obj);
	public boolean delete(Object obj);
	public boolean isObject(Object obj);
}
