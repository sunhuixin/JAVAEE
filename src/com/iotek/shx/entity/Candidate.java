package com.iotek.shx.entity;

import java.util.Date;

public class Candidate {
	private int cid;
	private User user;
	private Recruit recruit;
	private Date candidateTime;
	private String candidateStatus;
	public Candidate(int cid, User user, Recruit recruit, Date candidateTime, String candidateStatus) {
		super();
		this.cid = cid;
		this.user = user;
		this.recruit = recruit;
		this.candidateTime = candidateTime;
		this.candidateStatus = candidateStatus;
	}
	public Candidate() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}
	public Date getCandidateTime() {
		return candidateTime;
	}
	public void setCandidateTime(Date candidateTime) {
		this.candidateTime = candidateTime;
	}
	public String getCandidateStatus() {
		return candidateStatus;
	}
	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
	@Override
	public String toString() {
		return "Candidate [cid=" + cid + ", user=" + user + ", recruit=" + recruit + ", candidateTime=" + candidateTime
				+ ", candidateStatus=" + candidateStatus + "]";
	}
	
}
