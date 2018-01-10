package com.iotek.shx.entity;

import java.util.Date;
//考勤
public class Attendance {
	private int attendId;
	private Employee emp;
	private String inClock;//上班时间
	private String outClock;//下班时间
	private Date date;
	private int late;
	public Attendance(int attendId, Employee emp, String inClock, String outClock, Date date, int late) {
		super();
		this.attendId = attendId;
		this.emp = emp;
		this.inClock = inClock;
		this.outClock = outClock;
		this.date = date;
		this.late = late;
	}
	public Attendance() {
		super();
	}
	public int getAttendId() {
		return attendId;
	}
	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public String getInClock() {
		return inClock;
	}
	public void setInClock(String inClock) {
		this.inClock = inClock;
	}
	public String getOutClock() {
		return outClock;
	}
	public void setOutClock(String outClock) {
		this.outClock = outClock;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	@Override
	public String toString() {
		return "Attendance [attendId=" + attendId + ", emp=" + emp + ", inClock=" + inClock + ", outClock=" + outClock
				+ ", date=" + date + ", late=" + late + "]";
	}
	
	

}
