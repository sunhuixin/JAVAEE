package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Training;

public interface TrainingService {
	public int insertByEmp(Training train);

	public Training queryByEmpId(int empId);

	public int updateByEmpId(int empId);

	public List<Training> queryAll();

	public int deleteById(int trainId);
}
