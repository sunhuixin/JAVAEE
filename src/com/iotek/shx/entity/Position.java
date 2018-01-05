package com.iotek.shx.entity;

import java.util.Date;

public class Position {
	private int pId;
	private String pName;
	private Date generateTime;
	private Department depart;
	public Position(int pId, String pName,Date generateTime, Department depart) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.generateTime=generateTime;
		this.depart = depart;
	}
	public Position() {
		super();
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
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
		return "Position [pId=" + pId + ", pName=" + pName + ", generateTime=" + generateTime 
				+ "]";
	}
	
	
	
}
