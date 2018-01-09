package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Recruit;

public interface RecruitService {
	public List<Recruit> findAll();
	public int saveRecruit(Recruit recruit);
	public int updateRecruit(Recruit recruit);
	public int deleteRecruit(int id);
}
