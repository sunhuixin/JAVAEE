package com.iotek.shx.entity;

public class ResumeInfo {
	private Resume resume;
	private Administrator admin;
	private Department depart;
	private Position position;
	private int hire;
	private int check;	
	private int send;
	public ResumeInfo(Resume resume, Administrator admin, Department depart, Position position, int hire, int check,
			int send) {
		super();
		this.resume = resume;
		this.admin = admin;
		this.depart = depart;
		this.position = position;
		this.hire = hire;
		this.check = check;
		this.send = send;
	}
	public ResumeInfo() {
		super();
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
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
	public int getHire() {
		return hire;
	}
	public void setHire(int hire) {
		this.hire = hire;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public int getSend() {
		return send;
	}
	public void setSend(int send) {
		this.send = send;
	}
	@Override
	public String toString() {
		return "ResumeInfo [resume=" + resume + ", admin=" + admin + ", depart=" + depart + ", position=" + position
				+ ", hire=" + hire + ", check=" + check + ", send=" + send + "]";
	}
	
}
