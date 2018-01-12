package com.iotek.shx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.RewardAndPunishmentDao;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.RewardAndPunishment;
import com.iotek.shx.service.RewardAndPunishmentService;
@Service("rapService")
public class RewardAndPunishmentServiceImpl implements RewardAndPunishmentService {
	@Autowired
	private RewardAndPunishmentDao rapDao;

	@Override
	public int insert(Employee employee, double sum, Date date) {
		return rapDao.insert(employee, sum, date);
	}

	@Override
	public List<RewardAndPunishment> queryByEmpId(int empId) {
		return rapDao.queryByEmpId(empId);
	}

	@Override
	public int updateByEmpId(Employee employee, double sum, Date date) {
		return rapDao.updateByEmpId(employee, sum, date);
	}

	@Override
	public RewardAndPunishment queryByEmpIdAndDate(int empId, Date date) {
		return rapDao.queryByEmpIdAndDate(empId, date);
	}

	@Override
	public List<RewardAndPunishment> queryByEmpIdBetween(int empId, Date startDate, Date endDate) {
		return rapDao.queryByEmpIdBetween(empId, startDate, endDate);
	}

	@Override
	public List<RewardAndPunishment> queryByDepartId(int departId) {
		return rapDao.queryByDepartId(departId);
	}

	@Override
	public int updatePaydById(int rapId) {
		return rapDao.updatePaydById(rapId);
	}

	@Override
	public int insertByRap(RewardAndPunishment rap, Date date) {
		return rapDao.insertByRap(rap, date);
	}

}
