package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.DimissionDao;
import com.iotek.shx.entity.Dimission;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.service.DimissionService;
@Service("dimissService")
public class DimissionServiceImpl implements DimissionService {
	@Autowired
	private DimissionDao dimissDao;
	@Override
	public int add(Employee employee, String dimissReason) {
		return dimissDao.insert(employee, dimissReason);
	}

	@Override
	public List<Dimission> findAll() {
		return dimissDao.queryAll();
	}

}
