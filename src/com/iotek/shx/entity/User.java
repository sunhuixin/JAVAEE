package com.iotek.shx.entity;

import java.util.Date;

public class User{
	private int userId;//用户id
	private String userName;//用户名
	private String password;//用户密码
	private String realName;//真是姓名
	private int age;//年龄
	private int type;//0代表游客1代表员工2代表管理员
	private int status;
	private Department depart;//部门
	private Position position;//职位
	private Date entryTime;//入职时间
	private double baseSalary;//基本薪资
	
	public User(int userId, String userName, String password, String realName, int age, int type,int status, Department depart,
			Position position, Date entryTime, double baseSalary) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.age = age;
		this.type = type;
		this.status=status;
		this.depart = depart;
		this.position = position;
		this.entryTime = entryTime;
		this.baseSalary = baseSalary;
		
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
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", realName=" + realName
				+ ", age=" + age + ", type=" + type + ", status=" + status + ", depart=" + depart + ", position="
				+ position + ", entryTime=" + entryTime + ", baseSalary=" + baseSalary + "]";
	}
	
	
}