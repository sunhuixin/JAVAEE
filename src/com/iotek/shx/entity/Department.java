package com.iotek.shx.entity;

import java.util.List;

public class Department {
	private int id;
	private String name;
	private List<Position> position;
	
	public Department(int id, String name, List<Position> position) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
	}
	public Department() {
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
	public List<Position> getPosition() {
		return position;
	}
	public void setPosition(List<Position> position) {
		this.position = position;
	}
	

}
