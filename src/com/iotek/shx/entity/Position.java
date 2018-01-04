package com.iotek.shx.entity;

public class Position {
	private int id;
	private String name;
	private Department depart;
	public Position(int id, String name,Department depart) {
		super();
		this.id = id;
		this.name = name;
		this.depart=depart;
	}
	public Position() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	
}
