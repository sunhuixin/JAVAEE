package com.iotek.shx.entity;

public class Recruit {
	private int recruitId;
	private Department depart;
	private Position position;
	private double salary;
	private String title;
	private Administrator admin;
	public Recruit(int recruitId, Department depart, Position position, double salary, String title,
			Administrator admin) {
		super();
		this.recruitId = recruitId;
		this.depart = depart;
		this.position = position;
		this.salary = salary;
		this.title = title;
		this.admin = admin;
	}
	public Recruit() {
		super();
	}
	public int getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(int recruitId) {
		this.recruitId = recruitId;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Recruit [recruitId=" + recruitId + ", depart=" + depart + ", position=" + position + ", salary="
				+ salary + ", title=" + title + ", admin=" + admin + "]";
	}
	
	

}
