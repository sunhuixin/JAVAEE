package com.iotek.shx.entity;

import java.util.Date;

public class RewardAndPunishment {
	private int rapId;
	private Employee emp;
	private double baseSalary;
	private double rapSalary;
	private int rapYear;
	private int rapMonth;
	private Date rapTime;
	private int pay;
	
	public RewardAndPunishment(int rapId, Employee emp, double baseSalary, double rapSalary, int rapYear, int rapMonth,
			Date rapTime,int pay) {
		super();
		this.rapId = rapId;
		this.emp = emp;
		this.baseSalary = baseSalary;
		this.rapSalary = rapSalary;
		this.rapYear = rapYear;
		this.rapMonth = rapMonth;
		this.rapTime = rapTime;
		this.pay=pay;
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
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
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
	public int getRapYear() {
		return rapYear;
	}
	public void setRapYear(int rapYear) {
		this.rapYear = rapYear;
	}
	public int getRapMonth() {
		return rapMonth;
	}
	public void setRapMonth(int rapMonth) {
		this.rapMonth = rapMonth;
	}
	public Date getRapTime() {
		return rapTime;
	}
	public void setRapTime(Date rapTime) {
		this.rapTime = rapTime;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		return "RewardAndPunishment [rapId=" + rapId + ", emp=" + emp + ", baseSalary=" + baseSalary + ", rapSalary="
				+ rapSalary + ", rapYear=" + rapYear + ", rapMonth=" + rapMonth + ", rapTime=" + rapTime + ", pay="
				+ pay + "]";
	}
	
	
	
}
