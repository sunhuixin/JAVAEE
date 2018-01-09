package com.iotek.shx.entity;

public class Resume {
	private int id;
	private int userId;
	private String realName;
	private String gender;
	private int age;
	private String degree;
	private String phoneNumber;
	private String email;
	private Department depart;
	private Position position;
	private String politicalStatus;
	private String lastJob;
	private String workExpirence;
	private String expectedSalary;
	private String hobby;
	
	public Resume(int id, int userId, String realName, String gender, int age, String degree, String phoneNumber,
			String email, Department depart, Position position, String politicalStatus, String lastJob,
			String workExpirence, String expectedSalary, String hobby) {
		super();
		this.id = id;
		this.userId = userId;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.degree = degree;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.depart = depart;
		this.position = position;
		this.politicalStatus = politicalStatus;
		this.lastJob = lastJob;
		this.workExpirence = workExpirence;
		this.expectedSalary = expectedSalary;
		this.hobby = hobby;
	}
	public Resume(int userId, String realName, String gender, int age, String degree, String phoneNumber, String email,
			Department depart, String politicalStatus, String lastJob, String workExpirence, String expectedSalary,
			String hobby,String sign) {
		super();
		this.userId = userId;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.degree = degree;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.depart = depart;
		this.politicalStatus = politicalStatus;
		this.lastJob = lastJob;
		this.workExpirence = workExpirence;
		this.expectedSalary = expectedSalary;
		this.hobby = hobby;
	}
	public Resume() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	public String getLastJob() {
		return lastJob;
	}
	public void setLastJob(String lastJob) {
		this.lastJob = lastJob;
	}
	public String getWorkExpirence() {
		return workExpirence;
	}
	public void setWorkExpirence(String workExpirence) {
		this.workExpirence = workExpirence;
	}
	public String getExpectedSalary() {
		return expectedSalary;
	}
	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "Resume [id=" + id + ", userId=" + userId + ", realName=" + realName + ", gender=" + gender + ", age="
				+ age + ", degree=" + degree + ", phoneNumber=" + phoneNumber + ", email=" + email + ", depart="
				+ depart + ", position=" + position + ", politicalStatus=" + politicalStatus + ", lastJob=" + lastJob
				+ ", workExpirence=" + workExpirence + ", expectedSalary=" + expectedSalary + ", hobby=" + hobby
				+  "]";
	}
	

}
