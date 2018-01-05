package com.iotek.shx.entity;

public class Salary {
	private int salaryId;
	private User user;
	private double baseSalary;
	private double performanceSalary;
	private double overTimePay;
	private double rapSalary;
	private double socialSecurity;
	public Salary(int salaryId, User user, double baseSalary, double performanceSalary, double overTimePay,
			double rapSalary, double socialSecurity) {
		super();
		this.salaryId = salaryId;
		this.user = user;
		this.baseSalary = baseSalary;
		this.performanceSalary = performanceSalary;
		this.overTimePay = overTimePay;
		this.rapSalary = rapSalary;
		this.socialSecurity = socialSecurity;
	}
	public Salary() {
		super();
	}
	public int getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
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
	public double getPerformanceSalary() {
		return performanceSalary;
	}
	public void setPerformanceSalary(double performanceSalary) {
		this.performanceSalary = performanceSalary;
	}
	public double getOverTimePay() {
		return overTimePay;
	}
	public void setOverTimePay(double overTimePay) {
		this.overTimePay = overTimePay;
	}
	public double getRapSalary() {
		return rapSalary;
	}
	public void setRapSalary(double rapSalary) {
		this.rapSalary = rapSalary;
	}
	public double getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(double socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", user=" + user + ", baseSalary=" + baseSalary + ", performanceSalary="
				+ performanceSalary + ", overTimePay=" + overTimePay + ", rapSalary=" + rapSalary + ", socialSecurity="
				+ socialSecurity + "]";
	}
	

}
