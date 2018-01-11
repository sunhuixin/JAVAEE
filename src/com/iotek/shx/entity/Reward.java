package com.iotek.shx.entity;

import java.util.Date;

public class Reward {
	private int rewardId;
	private String rewardReason;
	private double rewardMoney;
	private Date rewardTime;
	private Employee emp;
	private Administrator admin;
	public Reward(int rewardId, String rewardReason, double rewardMoney, Date rewardTime, Employee emp,
			Administrator admin) {
		super();
		this.rewardId = rewardId;
		this.rewardReason = rewardReason;
		this.rewardMoney = rewardMoney;
		this.rewardTime = rewardTime;
		this.emp = emp;
		this.admin = admin;
	}
	public Reward() {
		super();
	}
	public int getRewardId() {
		return rewardId;
	}
	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}
	public String getRewardReason() {
		return rewardReason;
	}
	public void setRewardReason(String rewardReason) {
		this.rewardReason = rewardReason;
	}
	public double getRewardMoney() {
		return rewardMoney;
	}
	public void setRewardMoney(double rewardMoney) {
		this.rewardMoney = rewardMoney;
	}
	public Date getRewardTime() {
		return rewardTime;
	}
	public void setRewardTime(Date rewardTime) {
		this.rewardTime = rewardTime;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Reward [rewardId=" + rewardId + ", rewardReason=" + rewardReason + ", rewardMoney=" + rewardMoney
				+ ", rewardTime=" + rewardTime + ", emp=" + emp + ", admin=" + admin + "]";
	}
	
	
}
