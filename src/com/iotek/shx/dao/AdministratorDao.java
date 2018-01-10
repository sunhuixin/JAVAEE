package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.Administrator;

public interface AdministratorDao {
	public Administrator queryByNameAndPassword(Administrator admin);

	public List<Administrator> queryByDepartId(int departId);

	public Administrator queryById(int adminId);
}
