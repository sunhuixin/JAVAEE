package com.iotek.shx.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Attendance;

public interface AttendanceDao {
	/**
	 * ����Ա��id,��ǰ����,�ַ���ʱ�����һ��Attendance������
	 * @param empId
	 * @param date
	 * @param time
	 * @return
	 */
	public int insertOnTimeByEmpId(@Param("empId")int empId,@Param("date")Date date,@Param("time")String time);
	
	/**
	 * ����Ա��id,��ǰ����,�ַ���ʱ���޸�һ��Attendance������
	 * @param empId
	 * @param date
	 * @param time
	 * @return
	 */
	public int updateOffTimeByEmpId(@Param("empId")Integer empId,@Param("date")Date date,@Param("time")String time);

	/**
	 * ����empId ���Ա�����е�Attendance������
	 * @param empId
	 * @return
	 */
	public List<Attendance> queryByEmpId(int empId);

	/**
	 * ����date empId ��ѯ����� Attendance������
	 * @param date
	 * @param empId
	 * @return
	 */
	public Attendance queryByEmpIdAndDate(@Param("date")Date date, @Param("empId")int empId);

	public int updateLate2(@Param("empId")int empId,@Param("date") Date date);

	public int updateLate0(@Param("empId")int empId,@Param("date") Date date);

	public int updateLate1(@Param("empId")int empId,@Param("date") Date date);

}
