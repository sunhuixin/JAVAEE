package com.iotek.shx.entity;

import java.util.Date;

public class Employee {
	private int empId;
	private User user;
	private String empName;
	private Date empAge;
	private Department depart;
	private Position position;
	private double baseSalary;
	private Date empDate;
	private String empEmail;
	private Integer empPoliticalStatus;
	public Employee(int empId, User user, String empName, Date empAge, Department depart, Position position,
			double baseSalary, Date empDate, String empEmail, Integer empPoliticalStatus) {
		super();
		this.empId = empId;
		this.user = user;
		this.empName = empName;
		this.empAge = empAge;
		this.depart = depart;
		this.position = position;
		this.baseSalary = baseSalary;
		this.empDate = empDate;
		this.empEmail = empEmail;
		this.empPoliticalStatus = empPoliticalStatus;
	}
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Date empAge) {
		this.empAge = empAge;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Date getEmpDate() {
		return empDate;
	}
	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public Integer getEmpPoliticalStatus() {
		return empPoliticalStatus;
	}
	public void setEmpPoliticalStatus(Integer empPoliticalStatus) {
		this.empPoliticalStatus = empPoliticalStatus;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", user=" + user + ", empName=" + empName + ", empAge=" + empAge
				+ ", depart=" + depart + ", position=" + position + ", baseSalary=" + baseSalary + ", empDate="
				+ empDate + ", empEmail=" + empEmail + ", empPoliticalStatus=" + empPoliticalStatus + "]";
	}
	
}
