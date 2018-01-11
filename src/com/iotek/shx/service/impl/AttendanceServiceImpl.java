package com.iotek.shx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.AttendanceDao;
import com.iotek.shx.entity.Attendance;
import com.iotek.shx.service.AttendanceService;
@Service("attendService")
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceDao attendDao;
	@Override
	public int addOnTimeByEmpId(int empId, Date date, String time) {
		return attendDao.insertOnTimeByEmpId(empId, date, time);
	}

	@Override
	public int updateOffTimeByEmpId(Integer empId, Date date, String time) {
		return attendDao.updateOffTimeByEmpId(empId, date, time);
	}

	@Override
	public List<Attendance> findByEmpId(int empId) {
		return attendDao.queryByEmpId(empId);
	}

	@Override
	public Attendance findByEmpIdAndDate(Date date, int empId) {
		return attendDao.queryByEmpIdAndDate(date, empId);
	}

	@Override
	public int updateLate2(int empId, Date date) {
		return attendDao.updateLate2(empId, date);
	}

	@Override
	public int updateLate0(int empId, Date date) {
		return attendDao.updateLate0(empId, date);
	}

	@Override
	public int updateLate1(int empId, Date date) {
		return attendDao.updateLate1(empId, date);
	}

}
