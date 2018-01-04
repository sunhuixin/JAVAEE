package com.iotek.shx.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Department {
	private int dId;
	private String dName;
	private Date createTime;
	private Set<Position> position=new HashSet<Position>();
	public Department(int dId, String dName, Date createTime,Set<Position> position) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.createTime=createTime;
		this.position = position;
	}
	public Department() {
		super();
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set<Position> getPosition() {
		return position;
	}
	public void setPosition(Set<Position> position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + ", createTime=" + createTime + ", position=" + position
				+ "]";
	}
	
	
	

}
