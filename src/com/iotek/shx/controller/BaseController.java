package com.iotek.shx.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.iotek.shx.service.AdministratorService;
import com.iotek.shx.service.AttendanceService;
import com.iotek.shx.service.DepartService;
import com.iotek.shx.service.EmployeeService;
import com.iotek.shx.service.PositionService;
import com.iotek.shx.service.PunishmentService;
import com.iotek.shx.service.RecruitService;
import com.iotek.shx.service.ResumeService;
import com.iotek.shx.service.RewardAndPunishmentService;
import com.iotek.shx.service.RewardService;
import com.iotek.shx.service.TrainingService;
import com.iotek.shx.service.UserService;

public class BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private DepartService deptService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private AdministratorService adminService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RewardService rewardService;
	@Autowired
	private PunishmentService punishmentService;
	@Autowired
	private RewardAndPunishmentService rapService;
	@Autowired
	private AttendanceService attendService;
	@Autowired
	private TrainingService trainService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public DepartService getDeptService() {
		return deptService;
	}
	public void setDeptService(DepartService deptService) {
		this.deptService = deptService;
	}
	public PositionService getPositionService() {
		return positionService;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	public ResumeService getResumeService() {
		return resumeService;
	}
	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	public AdministratorService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdministratorService adminService) {
		this.adminService = adminService;
	}
	public RecruitService getRecruitService() {
		return recruitService;
	}
	public void setRecruitService(RecruitService recruitService) {
		this.recruitService = recruitService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public RewardService getRewardService() {
		return rewardService;
	}
	public void setRewardService(RewardService rewardService) {
		this.rewardService = rewardService;
	}
	public PunishmentService getPunishmentService() {
		return punishmentService;
	}
	public void setPunishmentService(PunishmentService punishmentService) {
		this.punishmentService = punishmentService;
	}
	public RewardAndPunishmentService getRapService() {
		return rapService;
	}
	public void setRapService(RewardAndPunishmentService rapService) {
		this.rapService = rapService;
	}
	public AttendanceService getAttendService() {
		return attendService;
	}
	public void setAttendService(AttendanceService attendService) {
		this.attendService = attendService;
	}
	public TrainingService getTrainService() {
		return trainService;
	}
	public void setTrainService(TrainingService trainService) {
		this.trainService = trainService;
	}
	
}
