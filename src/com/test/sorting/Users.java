package com.test.sorting;

public class Users implements Comparable<Users>{
	
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int compareTo(Users u) {
		// TODO Auto-generated method stub
		return this.getUsername().compareTo(u.getUsername());
	}
	
	

}
