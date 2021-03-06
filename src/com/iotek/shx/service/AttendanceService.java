package com.iotek.shx.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Attendance;

public interface AttendanceService {
	
	public int addOnTimeByEmpId(@Param("empId")int empId,@Param("date")Date date,@Param("time")String time);
	
	public int updateOffTimeByEmpId(@Param("empId")Integer empId,@Param("date")Date date,@Param("time")String time);

	public List<Attendance> findByEmpId(int empId);

	public Attendance findByEmpIdAndDate(@Param("date")Date date, @Param("empId")int empId);
	//2表示旷工
	public int updateLate2(@Param("empId")int empId,@Param("date") Date date);
	//0表示正常
	public int updateLate0(@Param("empId")int empId,@Param("date") Date date);
	//1表示迟到
	public int updateLate1(@Param("empId")int empId,@Param("date") Date date);
}
