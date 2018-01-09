package com.iotek.shx.entity;

import java.util.Date;

public class Recruit {
//	ְλ��н��4001-6000Ԫ/�� �Ϻ����ʼ�����
//	�����ص㣺�Ϻ�
//	�������ڣ�����
//	�������ʣ�ȫְ
//	�������飺����
//	���ѧ������ר
//	��Ƹ������3�� 
//	ְλ����������ʦ
	private int rid;
	private String workPalce;
	private Date releaseTime;
	private String jobType;
	private String workExperience;
	private String minDegree;
	private int needNumber;
	private String positionCategory;
	private String positionDecription;
	private String companyProfile;
	public Recruit(int rid, String workPalce, Date releaseTime, String jobType, String workExperience, String minDegree,
			int needNumber, String positionCategory, String positionDecription, String companyProfile) {
		super();
		this.rid = rid;
		this.workPalce = workPalce;
		this.releaseTime = releaseTime;
		this.jobType = jobType;
		this.workExperience = workExperience;
		this.minDegree = minDegree;
		this.needNumber = needNumber;
		this.positionCategory = positionCategory;
		this.positionDecription = positionDecription;
		this.companyProfile = companyProfile;
	}
	public Recruit() {
		super();
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getWorkPalce() {
		return workPalce;
	}
	public void setWorkPalce(String workPalce) {
		this.workPalce = workPalce;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getMinDegree() {
		return minDegree;
	}
	public void setMinDegree(String minDegree) {
		this.minDegree = minDegree;
	}
	public int getNeedNumber() {
		return needNumber;
	}
	public void setNeedNumber(int needNumber) {
		this.needNumber = needNumber;
	}
	public String getPositionCategory() {
		return positionCategory;
	}
	public void setPositionCategory(String positionCategory) {
		this.positionCategory = positionCategory;
	}
	public String getPositionDecription() {
		return positionDecription;
	}
	public void setPositionDecription(String positionDecription) {
		this.positionDecription = positionDecription;
	}
	public String getCompanyProfile() {
		return companyProfile;
	}
	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}
	@Override
	public String toString() {
		return "Recruit [rid=" + rid + ", workPalce=" + workPalce + ", releaseTime=" + releaseTime + ", jobType="
				+ jobType + ", workExperience=" + workExperience + ", minDegree=" + minDegree + ", needNumber="
				+ needNumber + ", positionCategory=" + positionCategory + ", positionDecription=" + positionDecription
				+ ", companyProfile=" + companyProfile + "]";
	}
	
	

}
