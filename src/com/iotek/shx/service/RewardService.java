package com.iotek.shx.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Reward;

public interface RewardService {
	public int saveRward(Reward reward);
	public Reward queryRewardByEmpId(int empId);
	public List<Reward> queryRewardByEmpIdAndDate(@Param(value="empId")int empId,@Param(value="date")Date date);
}
