package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.Department;

public interface DepartmentDao {
	public int saveDepart(Department depart);
	public int deleteDepart(int id);
	public int updateDepart(int dId,String dName);
	public List<Department> queryAllDepart();
	public  Department queryDepart(int id);
}
