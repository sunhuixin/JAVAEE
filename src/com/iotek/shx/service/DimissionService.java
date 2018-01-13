package com.iotek.shx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Dimission;
import com.iotek.shx.entity.Employee;

public interface DimissionService {
	public int add(@Param("employee")Employee employee, @Param("dimissReason")String dimissReason);

	public List<Dimission> findAll();
}
