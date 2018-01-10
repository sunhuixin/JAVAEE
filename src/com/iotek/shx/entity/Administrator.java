package com.iotek.shx.entity;

import java.util.List;

public class Administrator {
	private int adminId;
	private String adminName;
	private String adminPassword;
	private int adminlevel;
	private Department depart;
	private List<Resume> resumes;
	public Administrator(int adminId, String adminName, String adminPassword, int adminlevel, Department depart,
			List<Resume> resumes) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminlevel = adminlevel;
		this.depart = depart;
		this.resumes = resumes;
	}
	public Administrator() {
		super();
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public int getAdminlevel() {
		return adminlevel;
	}
	public void setAdminlevel(int adminlevel) {
		this.adminlevel = adminlevel;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	public List<Resume> getResumes() {
		return resumes;
	}
	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}
	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminlevel=" + adminlevel + ", depart=" + depart + ", resumes=" + resumes + "]";
	}
	
	
	
	
}
