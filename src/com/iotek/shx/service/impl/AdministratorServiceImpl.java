package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.AdministratorDao;
import com.iotek.shx.entity.Administrator;
import com.iotek.shx.service.AdministratorService;
@Service("adminService")
public class AdministratorServiceImpl implements AdministratorService {
	@Autowired
	private AdministratorDao adminDao;
	@Override
	public Administrator findByNameAndPassword(Administrator admin) {
		return adminDao.queryByNameAndPassword(admin);
	}

	@Override
	public List<Administrator> findByDepartId(int departId) {
		return adminDao.queryByDepartId(departId);
	}

	@Override
	public Administrator findById(int adminId) {
		return adminDao.queryById(adminId);
	}

}
