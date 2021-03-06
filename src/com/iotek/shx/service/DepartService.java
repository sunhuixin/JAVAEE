package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Department;

public interface DepartService {
	public int addDepart(Department depart);
	public int deleteDepart(int id);
	public int updateDepart(int dId,String dName);
	public List<Department> findAllDepart();
	public Department findDepart(int id);
}
