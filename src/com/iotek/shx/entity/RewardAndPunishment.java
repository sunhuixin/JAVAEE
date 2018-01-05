package com.iotek.shx.entity;

import java.util.Date;

public class RewardAndPunishment {
	private int rapId;
	private User user;
	private double baseSalary;
	private double rapSalary;
	private String rapReason;
	private Date rapTime;
	public RewardAndPunishment(int rapId, User user, double baseSalary, double rapSalary, String rapReason,
			Date rapTime) {
		super();
		this.rapId = rapId;
		this.user = user;
		this.baseSalary = baseSalary;
		this.rapSalary = rapSalary;
		this.rapReason = rapReason;
		this.rapTime = rapTime;
	}
	public RewardAndPunishment() {
		super();
	}
	public int getRapId() {
		return rapId;
	}
	public void setRapId(int rapId) {
		this.rapId = rapId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getRapSalary() {
		return rapSalary;
	}
	public void setRapSalary(double rapSalary) {
		this.rapSalary = rapSalary;
	}
	public String getRapReason() {
		return rapReason;
	}
	public void setRapReason(String rapReason) {
		this.rapReason = rapReason;
	}
	public Date getRapTime() {
		return rapTime;
	}
	public void setRapTime(Date rapTime) {
		this.rapTime = rapTime;
	}
	@Override
	public String toString() {
		return "RewardAndPunishment [rapId=" + rapId + ", user=" + user + ", baseSalary=" + baseSalary + ", rapSalary="
				+ rapSalary + ", rapReason=" + rapReason + ", rapTime=" + rapTime + "]";
	}
	
	
}
