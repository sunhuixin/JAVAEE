package com.iotek.shx.entity;

public class Objection {
	private int objectionId;
	private Reward reward;
	private Punishment punishment;
	private Employee employee;
	private Administrator admin;
	private String objectionReason;
	private Integer agreed;
	private RewardAndPunishment rap;
	public Objection(int objectionId, Reward reward, Punishment punishment, Employee employee, Administrator admin,
			String objectionReason, Integer agreed, RewardAndPunishment rap) {
		super();
		this.objectionId = objectionId;
		this.reward = reward;
		this.punishment = punishment;
		this.employee = employee;
		this.admin = admin;
		this.objectionReason = objectionReason;
		this.agreed = agreed;
		this.rap = rap;
	}
	public Objection() {
		super();
	}
	public int getObjectionId() {
		return objectionId;
	}
	public void setObjectionId(int objectionId) {
		this.objectionId = objectionId;
	}
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
	public Punishment getPunishment() {
		return punishment;
	}
	public void setPunishment(Punishment punishment) {
		this.punishment = punishment;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public String getObjectionReason() {
		return objectionReason;
	}
	public void setObjectionReason(String objectionReason) {
		this.objectionReason = objectionReason;
	}
	public Integer getAgreed() {
		return agreed;
	}
	public void setAgreed(Integer agreed) {
		this.agreed = agreed;
	}
	public RewardAndPunishment getRap() {
		return rap;
	}
	public void setRap(RewardAndPunishment rap) {
		this.rap = rap;
	}
	@Override
	public String toString() {
		return "Objection [objectionId=" + objectionId + ", reward=" + reward + ", punishment=" + punishment
				+ ", employee=" + employee + ", admin=" + admin + ", objectionReason=" + objectionReason + ", agreed="
				+ agreed + ", rap=" + rap + "]";
	}
	
}
