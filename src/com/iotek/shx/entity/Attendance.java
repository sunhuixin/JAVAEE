package com.iotek.shx.entity;

import java.util.Date;
//����
public class Attendance {
	private int attendId;
	private User user;
	private Date inClock;//�ϰ�ʱ��
	private Date outClock;//�°�ʱ��
	private boolean isLater;//�Ƿ�ٵ�
	private boolean earlyLeave;//�Ƿ�����
	public Attendance(int attendId, User user, Date inClock, Date outClock, boolean isLater, boolean earlyLeave) {
		super();
		this.attendId = attendId;
		this.user = user;
		this.inClock = inClock;
		this.outClock = outClock;
		this.isLater = isLater;
		this.earlyLeave = earlyLeave;
	}
	public Attendance(User user, Date inClock, Date outClock, boolean isLater, boolean earlyLeave) {
		super();
		this.user = user;
		this.inClock = inClock;
		this.outClock = outClock;
		this.isLater = isLater;
		this.earlyLeave = earlyLeave;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getInClock() {
		return inClock;
	}
	public void setInClock(Date inClock) {
		this.inClock = inClock;
	}
	public Date getOutClock() {
		return outClock;
	}
	public void setOutClock(Date outClock) {
		this.outClock = outClock;
	}
	public boolean isLater() {
		return isLater;
	}
	public void setLater(boolean isLater) {
		this.isLater = isLater;
	}
	public boolean isEarlyLeave() {
		return earlyLeave;
	}
	public void setEarlyLeave(boolean earlyLeave) {
		this.earlyLeave = earlyLeave;
	}
	@Override
	public String toString() {
		return "Attendance [attendId=" + attendId + ", user=" + user + ", inClock=" + inClock + ", outClock=" + outClock
				+ ", isLater=" + isLater + ", earlyLeave=" + earlyLeave + "]";
	}
	

}
