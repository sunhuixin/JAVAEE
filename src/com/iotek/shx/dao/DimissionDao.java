package com.iotek.shx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Dimission;
import com.iotek.shx.entity.Employee;

public interface DimissionDao {
	public int insert(@Param("employee")Employee employee, @Param("dimissReason")String dimissReason);

	public List<Dimission> queryAll();
}
