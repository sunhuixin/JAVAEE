package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Administrator;

public interface AdministratorService {
	
	public Administrator findByNameAndPassword(Administrator admin);

	public List<Administrator> findByDepartId(int departId);

	public Administrator findById(int adminId);

}
