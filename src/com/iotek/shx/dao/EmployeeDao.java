package com.iotek.shx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Resume;

public interface EmployeeDao {
	
	public int insert(Resume resume);
	
	/**
	 * 根据部门id查找Employee的集合
	 * @param departId
	 * @return
	 */
	public List<Employee> queryByDepartId(int departId);

	/**
	 * 根据empId查找单个员工
	 * @param empId
	 * @return
	 */
	public Employee queryByEmpId(int empId);

	public int updateByEmpId(@Param("empId")int empId,@Param("departId")int departId,@Param("positionId")int positionId);

	public int updateSalaryByEmpId(@Param("empId")int empId,@Param("addSalary")Double addSalary);
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> queryAll();

	/**
	 * 根据positionId查询所有员工
	 * @param positionId
	 * @return
	 */
	public List<Employee> queryByPositionId(int positionId);

	/**
	 * 根据empId删除员工
	 * @param empId
	 * @return
	 */
	public int deleteByEmpId(int empId);
}
