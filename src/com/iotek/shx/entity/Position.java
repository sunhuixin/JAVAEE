package com.iotek.shx.entity;

public class Position {
	private int id;
	private String name;
	public Position(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
