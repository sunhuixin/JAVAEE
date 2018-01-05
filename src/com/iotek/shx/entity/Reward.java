package com.iotek.shx.entity;

import java.util.Date;

public class Reward {
	private int rewardId;
	private String rewardReason;
	private double rewardMoney;
	private Date rewardTime;
	private User user;
	public Reward(int rewardId, String rewardReason, double rewardMoney, Date rewardTime, User user) {
		super();
		this.rewardId = rewardId;
		this.rewardReason = rewardReason;
		this.rewardMoney = rewardMoney;
		this.rewardTime = rewardTime;
		this.user = user;
	}
	public Reward(String rewardReason, double rewardMoney, Date rewardTime, User user) {
		super();
		this.rewardReason = rewardReason;
		this.rewardMoney = rewardMoney;
		this.rewardTime = rewardTime;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Reward [rewardId=" + rewardId + ", rewardReason=" + rewardReason + ", rewardMoney=" + rewardMoney
				+ ", rewardTime=" + rewardTime + ", user=" + user + "]";
	}
	
}
