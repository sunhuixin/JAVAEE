package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.Salary;

public interface SalaryDao {
	public List<Salary> query(int empId);
	public List<Salary> queryAll();
	

}
