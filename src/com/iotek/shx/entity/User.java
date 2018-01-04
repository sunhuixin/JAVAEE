package com.iotek.shx.entity;

import java.util.Date;

public class User{
	private int userId;//用户id
	private String userName;//用户名
	private String password;//用户密码
	private int type;//0代表游客1代表员工2代表管理员
	private Department depart;
	private Position position;
	private Date entryTime;
	
	public User(int userId, String userName, String password, int type, Department depart, Position position,
			Date entryTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.depart = depart;
		this.position = position;
		this.entryTime = entryTime;
	}
	public User(int userId, String userName, String password,int type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.type=type;
	}
	public User(String userName, String password,int type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", type=" + type
				+ ", depart=" + depart + ", position=" + position + ", entryTime=" + entryTime + "]";
	}
	
	
}