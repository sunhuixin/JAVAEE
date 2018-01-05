package com.iotek.shx.entity;

import java.util.Date;

public class Training {
	private int trainingId;
	private String trainingTitle;
	private String trainingContent;
	private Date beginTime;
	private Date endTime;
	private Department depart;
	private User user;
	public Training(int trainingId, String trainingTitle, String trainingContent, Date beginTime, Date endTime,
			Department depart, User user) {
		super();
		this.trainingId = trainingId;
		this.trainingTitle = trainingTitle;
		this.trainingContent = trainingContent;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.depart = depart;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", trainingTitle=" + trainingTitle + ", trainingContent="
				+ trainingContent + ", beginTime=" + beginTime + ", endTime=" + endTime + ", depart=" + depart
				+ ", user=" + user + "]";
	}
	
}
