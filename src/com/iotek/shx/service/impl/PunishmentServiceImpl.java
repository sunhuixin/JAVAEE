package com.iotek.shx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.PunishmentDao;
import com.iotek.shx.entity.Punishment;
import com.iotek.shx.service.PunishmentService;
@Service("punishService")
public class PunishmentServiceImpl  implements PunishmentService{
	@Autowired
	private PunishmentDao punishDao;
	@Override
	public int savePunishment(Punishment punishment) {
		return punishDao.savePunishment(punishment);
	}

	@Override
	public List<Punishment> queryPunishmentByEmpId(int empId) {
		return punishDao.queryPunishmentByEmpId(empId);
	}

	@Override
	public List<Punishment> queryPunishmentByEmpIdAndDate(int empId, Date date) {
		return punishDao.queryPunishmentByEmpIdAndDate(empId, date);
	}

}
