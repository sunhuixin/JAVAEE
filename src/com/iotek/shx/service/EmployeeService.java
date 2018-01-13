package com.iotek.shx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Resume;

public interface EmployeeService {
	public int add(Resume resume);
	
	public List<Employee> findByDepartId(int departId);
	
	public Employee findByEmpId(int empId);

	public int updateByEmpId(@Param("empId")int empId,@Param("departId")int departId,@Param("positionId")int positionId);

	public int updateSalaryByEmpId(@Param("empId")int empId,@Param("addSalary")Double addSalary);
	
	public List<Employee> findAll();
	
	public List<Employee> findByPositionId(int positionId);

	public int deleteByEmpId(int empId);
}
