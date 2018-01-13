package com.iotek.shx.entity;

import java.util.Date;

public class Dimission {
	private Integer dimissId;
	private Employee employee;
	private Date time;
	private String dimissReason;
	public Dimission(Integer dimissId, Employee employee, Date time, String dimissReason) {
		super();
		this.dimissId = dimissId;
		this.employee = employee;
		this.time = time;
		this.dimissReason = dimissReason;
	}
	public Dimission() {
		super();
	}
	public Integer getDimissId() {
		return dimissId;
	}
	public void setDimissId(Integer dimissId) {
		this.dimissId = dimissId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDimissReason() {
		return dimissReason;
	}
	public void setDimissReason(String dimissReason) {
		this.dimissReason = dimissReason;
	}
	@Override
	public String toString() {
		return "Dimission [dimissId=" + dimissId + ", employee=" + employee + ", time=" + time + ", dimissReason="
				+ dimissReason + "]";
	}
	
}
