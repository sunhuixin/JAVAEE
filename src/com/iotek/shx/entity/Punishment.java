package com.iotek.shx.entity;

import java.util.Date;

public class Punishment {
	private int punishId;
	private String punishReason;
	private double punishMoney;
	private Date punishTime;
	private User user;
	public Punishment(int punishId, String punishReason, double punishMoney, Date punishTime, User user) {
		super();
		this.punishId = punishId;
		this.punishReason = punishReason;
		this.punishMoney = punishMoney;
		this.punishTime = punishTime;
		this.user = user;
	}
	public Punishment(String punishReason, double punishMoney, Date punishTime, User user) {
		super();
		this.punishReason = punishReason;
		this.punishMoney = punishMoney;
		this.punishTime = punishTime;
		this.user = user;
	}
	public Punishment() {
		super();
	}
	public int getPunishId() {
		return punishId;
	}
	public void setPunishId(int punishId) {
		this.punishId = punishId;
	}
	public String getPunishReason() {
		return punishReason;
	}
	public void setPunishReason(String punishReason) {
		this.punishReason = punishReason;
	}
	public double getPunishMoney() {
		return punishMoney;
	}
	public void setPunishMoney(double punishMoney) {
		this.punishMoney = punishMoney;
	}
	public Date getPunishTime() {
		return punishTime;
	}
	public void setPunishTime(Date punishTime) {
		this.punishTime = punishTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Punishment [punishId=" + punishId + ", punishReason=" + punishReason + ", punishMoney=" + punishMoney
				+ ", punishTime=" + punishTime + ", user=" + user + "]";
	}
	
	
	
}
