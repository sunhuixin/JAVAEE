package com.iotek.shx.service.impl;

import java.text.SimpleDateFormat;
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
	public int saveReward(Reward reward) {
		return rewardDao.saveReward(reward);
	}

	@Override
	public List<Reward> queryRewardByEmpId(int empId) {
		return rewardDao.queryRewardByEmpId(empId);
	}

	@Override
	public List<Reward> queryRewardByEmpIdAndDate(int empId, Date date) {
		return rewardDao.queryRewardByEmpIdAndDate(empId, date);
	}

	@Override
	public boolean overTime(Reward reward) {
		// TODO Auto-generated method stub
		boolean flag = true;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(reward);
		List<Reward> rewards = rewardDao.queryRewardByEmpId(reward.getEmp().getEmpId());
		
		for (Reward reward2 : rewards) {
			if(reward2.getRewardReason().equals(reward.getRewardReason())
					&&df.format(reward2.getRewardTime())
					.equals(df.format(reward.getRewardTime()))){
				flag = false;
			}
		}
		if(flag){
			flag=saveReward(reward)>0?true:false;
		}
		return flag;
	}
	

}
