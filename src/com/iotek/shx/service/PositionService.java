package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Position;

public interface PositionService {
	public int addPosition(Position position);
	public int deletePosition(int id);
	public int updatePosition(int pid,String pname,int departId);
	public Position findPosition(int pId);
	public List<Position> findPositionsByDepartId(int id);
}
