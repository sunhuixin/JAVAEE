package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iotek.shx.dao.EmployeeDao;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.service.EmployeeService;
@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao empDao;
	@Override
	public int add(Resume resume) {
		return empDao.insert(resume);
	}

	@Override
	public List<Employee> findByDepartId(int departId) {
		return empDao.queryByDepartId(departId);
	}

	@Override
	public Employee findByUserId(int empId) {
		return empDao.queryByUserId(empId);
	}

	@Override
	public int updateByEmpId(int empId, int departId, int positionId) {
		return empDao.updateByEmpId(empId, departId, positionId);
	}

	@Override
	public int updateSalaryByEmpId(int empId, Double addSalary) {
		return empDao.updateSalaryByEmpId(empId, addSalary);
	}

	@Override
	public List<Employee> findAll() {
		return empDao.queryAll();
	}

	@Override
	public List<Employee> findByPositionId(int positionId) {
		return empDao.queryByPositionId(positionId);
	}

	@Override
	public int deleteByEmpId(int empId) {
		return empDao.deleteByEmpId(empId);
	}

}
