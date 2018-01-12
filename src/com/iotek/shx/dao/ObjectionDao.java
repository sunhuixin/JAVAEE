package com.iotek.shx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Objection;

public interface ObjectionDao {
	public int insertPunish(@Param("employee")Employee employee, @Param("punishId")int punishId, @Param("objectionReason")String objectionReason, @Param("admin")Administrator admin);

	public int insertReward(@Param("employee")Employee employee,@Param("rewardId") int rewardId, @Param("objectionReason")String objectionReason, @Param("admin")Administrator admin);
	
	public Objection queryByPunishmentId(int punishId);
	
	public Objection queryByRewardId(int rewardId);

	public List<Objection> queryRewardByAdminId(int adminId);

	public List<Objection> queryPunishmentByAdminId(int adminId);
	
	public int update2ByObjectionId(int objectionId);
	
	public int update1ByObjectionId(@Param("objectionReason")String objectionReason,@Param("objectionId")int objectionId);

	public List<Objection> queryPunishmentByEmpId(int empId);

	public List<Objection> queryRewardByEmpId(int empId);

	public int insertS(@Param("empId")int empId, @Param("rapId")int rapId,@Param("objectionReason")String objetionReason);

	public Objection queryByRapId(int rapId);

	public List<Objection> querySByAid3();
	
	public List<Objection> querySByEmpId(int empId);
}
