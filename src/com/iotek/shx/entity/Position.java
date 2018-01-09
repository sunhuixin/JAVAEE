package com.iotek.shx.entity;

import java.util.Date;

public class Position {
	private int pid;
	private String pname;
	private Date generateTime;
	private Department depart;
	public Position(int pid, String pname,Date generateTime, Department depart) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.generateTime=generateTime;
		this.depart = depart;
	}
	public Position(int pid, String pname, Date generateTime) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.generateTime = generateTime;
	}

	public Position() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	@Override
	public String toString() {
		return "Position [pId=" + pid + ", pName=" + pname + ", generateTime=" + generateTime 
				+ "]";
	}
	
	
	
}
