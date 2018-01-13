package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iotek.shx.dao.ObjectionDao;
import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Objection;
import com.iotek.shx.service.ObjectionService;
@Service("objectionService")
public class ObjectionServiceImpl implements ObjectionService {
	private ObjectionDao objectionDao;

	@Override
	public int insertPunish(Employee employee, int punishId, String objectionReason, Administrator admin) {
		return objectionDao.insertPunish(employee, punishId, objectionReason, admin);
	}

	@Override
	public int insertReward(Employee employee, int rewardId, String objectionReason, Administrator admin) {
		return objectionDao.insertReward(employee, rewardId, objectionReason, admin);
	}

	@Override
	public Objection queryByPunishmentId(int punishId) {
		return objectionDao.queryByPunishmentId(punishId);
	}

	@Override
	public Objection queryByRewardId(int rewardId) {
		return objectionDao.queryByRewardId(rewardId);
	}

	@Override
	public List<Objection> queryRewardByAdminId(int adminId) {
		return objectionDao.queryRewardByAdminId(adminId);
	}

	@Override
	public List<Objection> queryPunishmentByAdminId(int adminId) {
		return objectionDao.queryPunishmentByAdminId(adminId);
	}

	@Override//2表示同意
	public int update2ByObjectionId(int objectionId) {
		return objectionDao.update2ByObjectionId(objectionId);
	}

	@Override//1表示否决
	public int update1ByObjectionId(String objectionReason, int objectionId) {
		return objectionDao.update1ByObjectionId(objectionReason, objectionId);
	}

	@Override
	public List<Objection> queryPunishmentByEmpId(int empId) {
		return objectionDao.queryPunishmentByEmpId(empId);
	}

	@Override
	public List<Objection> queryRewardByEmpId(int empId) {
		return objectionDao.queryRewardByEmpId(empId);
	}

	@Override
	public int addObjectionSalary(int empId, int rapId, String objetionReason) {
		return objectionDao.insertS(empId, rapId, objetionReason);
	}

	@Override
	public Objection queryByRapId(int rapId) {
		return objectionDao.queryByRapId(rapId);
	}

	@Override
	public List<Objection> querySByAid3() {
		return objectionDao.querySByAid3();
	}

	@Override
	public List<Objection> querySByEmpId(int empId) {
		return objectionDao.querySByEmpId(empId);
	}

}
