package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.Training;

public interface TrainingDao {
	public int insertByEmp(Training train);

	public Training queryByEmpId(int eid);

	public int updateByEid(Integer eid);

	public List<Training> queryAll();

	public int deleteById(int trainId);

}
