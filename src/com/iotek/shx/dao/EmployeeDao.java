package com.iotek.shx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Resume;

public interface EmployeeDao {
	
	public int insert(Resume resume);
	
	/**
	 * ���ݲ���id����Employee�ļ���
	 * @param departId
	 * @return
	 */
	public List<Employee> queryByDepartId(int departId);

	/**
	 * ����empId���ҵ���Ա��
	 * @param empId
	 * @return
	 */
	public Employee queryByEmpId(int empId);

	public int updateByEmpId(@Param("empId")int empId,@Param("departId")int departId,@Param("positionId")int positionId);

	public int updateSalaryByEmpId(@Param("empId")int empId,@Param("addSalary")Double addSalary);
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> queryAll();

	/**
	 * ����positionId��ѯ����Ա��
	 * @param positionId
	 * @return
	 */
	public List<Employee> queryByPositionId(int positionId);

	/**
	 * ����empIdɾ��Ա��
	 * @param empId
	 * @return
	 */
	public int deleteByEmpId(int empId);
}
