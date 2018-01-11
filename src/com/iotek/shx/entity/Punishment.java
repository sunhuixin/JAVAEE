package com.iotek.shx.entity;

import java.util.Date;

public class Punishment {
	private int punishId;
	private String punishReason;
	private double punishMoney;
	private Date punishTime;
	private Employee emp;
	public Punishment(int punishId, String punishReason, double punishMoney, Date punishTime, Employee emp) {
		super();
		this.punishId = punishId;
		this.punishReason = punishReason;
		this.punishMoney = punishMoney;
		this.punishTime = punishTime;
		this.emp = emp;
	}
	public Punishment(String punishReason, double punishMoney, Date punishTime, Employee emp) {
		super();
		this.punishReason = punishReason;
		this.punishMoney = punishMoney;
		this.punishTime = punishTime;
		this.emp = emp;
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
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Punishment [punishId=" + punishId + ", punishReason=" + punishReason + ", punishMoney=" + punishMoney
				+ ", punishTime=" + punishTime + ", emp=" + emp + "]";
	}
	
	
	
}
