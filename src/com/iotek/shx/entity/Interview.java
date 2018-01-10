package com.iotek.shx.entity;

import java.util.Date;

public class Interview {
	private Integer interviewId;
	private Resume resume;
	private String interviewPlace;
	private Date interviewTime;
	private Administrator admin;
	private int checked;
	private int replyed;
	private String interviewer;
	public Interview(Integer interviewId, Resume resume, String interviewPlace, Date interviewTime, Administrator admin,
			int checked, int replyed, String interviewer) {
		super();
		this.interviewId = interviewId;
		this.resume = resume;
		this.interviewPlace = interviewPlace;
		this.interviewTime = interviewTime;
		this.admin = admin;
		this.checked = checked;
		this.replyed = replyed;
		this.interviewer = interviewer;
	}
	public Interview() {
		super();
	}
	public Integer getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public String getInterviewPlace() {
		return interviewPlace;
	}
	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace;
	}
	public Date getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public int getReplyed() {
		return replyed;
	}
	public void setReplyed(int replyed) {
		this.replyed = replyed;
	}
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", resume=" + resume + ", interviewPlace=" + interviewPlace
				+ ", interviewTime=" + interviewTime + ", admin=" + admin + ", checked=" + checked + ", replyed="
				+ replyed + ", interviewer=" + interviewer + "]";
	}
	
	
	

}
