package com.iotek.shx.entity;

import java.util.Date;

public class Training {
	private int trainingId;
	private String trainingTitle;
	private String trainingContent;
	private Date beginTime;
	private Date endTime;
	private Administrator admin;
	private Department depart;
	private Employee emp;
	private int attended;
	public Training(int trainingId, String trainingTitle, String trainingContent, Date beginTime, Date endTime,
			Administrator admin, Department depart, Employee emp,int attended) {
		super();
		this.trainingId = trainingId;
		this.trainingTitle = trainingTitle;
		this.trainingContent = trainingContent;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.admin = admin;
		this.depart = depart;
		this.emp = emp;
		this.attended=attended;
	}
	public Training() {
		super();
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingTitle() {
		return trainingTitle;
	}
	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}
	public String getTrainingContent() {
		return trainingContent;
	}
	public void setTrainingContent(String trainingContent) {
		this.trainingContent = trainingContent;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getAttended() {
		return attended;
	}
	public void setAttended(int attended) {
		this.attended = attended;
	}
	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", trainingTitle=" + trainingTitle + ", trainingContent="
				+ trainingContent + ", beginTime=" + beginTime + ", endTime=" + endTime + ", admin=" + admin
				+ ", depart=" + depart + ", emp=" + emp + ", attended=" + attended + "]";
	}
	
	
	
}
