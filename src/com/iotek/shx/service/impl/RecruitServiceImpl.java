package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.RecruitDao;
import com.iotek.shx.entity.Recruit;
import com.iotek.shx.service.RecruitService;
@Service("recruitServcie")
public class RecruitServiceImpl implements RecruitService {
	@Autowired
	private RecruitDao recruitDao;

	@Override
	public List<Recruit> findAll() {
		return recruitDao.queryAll();
	}

	@Override
	public int saveRecruit(Recruit recruit) {
		return recruitDao.saveRecruit(recruit);
	}

	@Override
	public int updateRecruit(Recruit recruit) {
		return recruitDao.updateRecruit(recruit);
	}

	@Override
	public int deleteRecruit(int id) {
		return recruitDao.deleteRecruit(id);
	}


}
