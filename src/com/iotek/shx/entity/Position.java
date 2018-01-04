package com.iotek.shx.entity;

import java.util.Date;

public class Position {
	private int pId;
	private String pName;
	private Date createTime;
	private Department depart;
	public Position(int pId, String pName,Date createTime, Department depart) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.createTime=createTime;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	@Override
	public String toString() {
		return "Position [pId=" + pId + ", pName=" + pName + ", createTime=" + createTime + ", depart=" + depart + "]";
	}
	
	
	
}
