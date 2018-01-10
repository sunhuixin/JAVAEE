package com.iotek.shx.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Attendance;

public interface AttendanceDao {
	/**
	 * 根据员工id,当前日期,字符串时间插入一条Attendance表数据
	 * @param empId
	 * @param date
	 * @param time
	 * @return
	 */
	public int insertOnTimeByEmpId(@Param("empId")int empId,@Param("date")Date date,@Param("time")String time);
	
	/**
	 * 根据员工id,当前日期,字符串时间修改一条Attendance表数据
	 * @param empId
	 * @param date
	 * @param time
	 * @return
	 */
	public int updateOffTimeByEmpId(@Param("empId")Integer empId,@Param("date")Date date,@Param("time")String time);

	/**
	 * 根据empId 查该员工所有的Attendance表数据
	 * @param empId
	 * @return
	 */
	public List<Attendance> queryByEmpId(int empId);

	/**
	 * 根据date empId 查询当天的 Attendance表数据
	 * @param date
	 * @param empId
	 * @return
	 */
	public Attendance queryByEmpIdAndDate(@Param("date")Date date, @Param("empId")int empId);

	public int updateLate2(@Param("empId")int empId,@Param("date") Date date);

	public int updateLate0(@Param("empId")int empId,@Param("date") Date date);

	public int updateLate1(@Param("empId")int empId,@Param("date") Date date);

}
