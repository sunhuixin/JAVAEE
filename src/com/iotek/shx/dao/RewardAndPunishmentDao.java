package com.iotek.shx.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.RewardAndPunishment;

public interface RewardAndPunishmentDao {
	
	public int insert(@Param("employee")Employee employee,@Param("sum")double sum,@Param("date")Date date);
	
	public List<RewardAndPunishment> queryByEmpId(int empId);

	public int updateByEmpId(@Param("employee")Employee employee,@Param("sum")double sum,@Param("date")Date date);

	public RewardAndPunishment queryByEmpIdAndDate(@Param("empId")int empId,@Param("date")Date date);

	public List<RewardAndPunishment> queryByEmpIdBetween(@Param("empId")int empId, @Param("startDate")Date startDate,@Param("endDate") Date endDate);

	public List<RewardAndPunishment> queryByDepartId(int departId);

	public int updatePaydById(int rapId);

	public int insertByRap(@Param("rap")RewardAndPunishment rap,@Param("date")Date date);
}
