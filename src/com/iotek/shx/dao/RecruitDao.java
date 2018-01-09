package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.Recruit;

public interface RecruitDao {
	public List<Recruit> queryAll();
	public int saveRecruit(Recruit recruit);
	public int updateRecruit(Recruit recruit);
	public int deleteRecruit(int id);

}
