package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.TrainingDao;
import com.iotek.shx.entity.Training;
import com.iotek.shx.service.TrainingService;
@Service("trainService")
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingDao trainDao;

	@Override
	public int insertByEmp(Training train) {
		return trainDao.insertByEmp(train);
	}

	@Override
	public Training queryByEmpId(int empId) {
		return trainDao.queryByEmpId(empId);
	}

	@Override
	public int updateByEmpId(int empId) {
		return trainDao.updateByEmpId(empId);
	}

	@Override
	public List<Training> queryAll() {
		return trainDao.queryAll();
	}

	@Override
	public int deleteById(int trainId) {
		return trainDao.deleteById(trainId);
	}

	@Override
	public int addBySuperAdmin(Training train, Integer[] eids, Integer[] deptIds) {
		// TODO Auto-generated method stub
		return 0;
	}

}
