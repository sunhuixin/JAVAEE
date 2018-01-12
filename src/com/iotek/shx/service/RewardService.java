package com.iotek.shx.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Reward;

public interface RewardService {
	public int saveReward(Reward reward);
	public List<Reward> queryRewardByEmpId(int empId);
	public List<Reward> queryRewardByEmpIdAndDate(@Param(value="empId")int empId,@Param(value="date")Date date);
	public boolean overTime(Reward reward);
}
