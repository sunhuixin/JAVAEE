package com.iotek.shx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.RewardDao;
import com.iotek.shx.entity.Reward;
import com.iotek.shx.service.RewardService;
@Service("rewardService")
public class RewardServiceImpl implements RewardService {
	@Autowired
	private RewardDao rewardDao;
	@Override
	public int saveRward(Reward reward) {
		return rewardDao.saveRward(reward);
	}

	@Override
	public Reward queryRewardByEmpId(int empId) {
		return rewardDao.queryRewardByEmpId(empId);
	}

	@Override
	public List<Reward> queryRewardByEmpIdAndDate(int empId, Date date) {
		return rewardDao.queryRewardByEmpIdAndDate(empId, date);
	}

}
