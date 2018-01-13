package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.DepartmentDao;
import com.iotek.shx.entity.Department;
import com.iotek.shx.service.DepartService;
@Service("departServcie")
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartmentDao departDao;
	@Override
	public int addDepart(Department depart) {
		return departDao.saveDepart(depart);
	}

	@Override
	public int deleteDepart(int id) {
		return departDao.deleteDepart(id);
	}

	@Override
	public int updateDepart(int dId,String dName) {
		return departDao.updateDepart(dId,dName);
	}

	@Override
	public List<Department> findAllDepart() {
		return departDao.queryAllDepart();
	}

	@Override
	public Department findDepart(int id) {
		return departDao.queryDepart(id);
	}

}
