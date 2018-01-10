package com.iotek.shx.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Punishment;

public interface PunishmentDao {
	public int savePunishment(Punishment punishment);
	public List<Punishment> queryPunishmentByEmpId(int empId);
	public List<Punishment> queryPunishmentByEmpIdAndDate(@Param(value="empId")int empId,@Param(value="date")Date date);

}
